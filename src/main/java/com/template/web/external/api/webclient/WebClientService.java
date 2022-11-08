package com.template.web.external.api.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.template.web.external.api.domain.ExternalApiRequest;
import com.template.web.external.api.domain.ExternalApiResponse;
import com.template.web.external.api.domain.ExternalCommonApiResponse;
import com.template.web.common.domain.dto.ApiConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.function.Consumer;

import static com.template.web.external.api.constants.ApiCodeConstants.SUCCESS_CODE;
import static com.template.web.external.api.constants.ApiFieldConstants.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebClientService {

    private static final int TIMEOUT_SEC = 10;

    @Value("${api.domain}")
    private String apiDomain;

    private final WebClient webClient = WebClient.create();

    public <T extends ExternalApiResponse> T executeGet(String apiUri, ApiConfig config
            , TypeReference<ExternalCommonApiResponse<T>> typeReference) throws Exception {
        return executeGet(apiUri, null, config, typeReference);
    }

    public <T extends ExternalApiResponse> T executeGet(String apiUri
            , ExternalApiRequest request, ApiConfig config
            , TypeReference<ExternalCommonApiResponse<T>> typeReference) throws Exception {

        Consumer<HttpHeaders> headers = WebClientHeaderUtil.make(config.getApiId(), config.getReqUniqNo(), config.getSignKey());

        URI uri;
        HashMap<String, String> parameters = null;
        if (ObjectUtils.isEmpty(request)) {
            uri = WebClientUriUtil.makeGetUri(new URI(apiDomain), apiUri);
        } else {
            parameters = new ObjectMapper().convertValue(request, HashMap.class);
            uri = WebClientUriUtil.makeGetUri(new URI(apiDomain), apiUri, parameters);
        }

        log.info("request get - uri: {}, parameters: {}", apiUri, parameters);
        ExternalCommonApiResponse<T> apiResponse = get(headers, uri, typeReference);
        if (!SUCCESS_CODE.equals(apiResponse.getCode())) {
            throw new Exception(apiResponse.getCode() + " - " + apiResponse.getMessage());
        }

        return apiResponse.getData();
    }

    public <T extends ExternalApiResponse> T executePost(String apiUri
            , ExternalApiRequest request, ApiConfig config, TypeReference<ExternalCommonApiResponse<T>> typeReference) throws Exception {

        Consumer<HttpHeaders> headers = WebClientHeaderUtil.make(config.getApiId(), config.getReqUniqNo(), config.getSignKey());

        String jsonBody = new ObjectMapper().writeValueAsString(request);
        log.info("request post - uri: {}, body: {}", apiUri, jsonBody);
        ExternalCommonApiResponse<T> apiResponse = post(headers, apiDomain + apiUri, jsonBody, typeReference);

        if (!SUCCESS_CODE.equals(apiResponse.getCode())) {
            log.error("invalid response code - code: {}, status: {}, message: {}", apiResponse.getCode(), apiResponse.getStatus(), apiResponse.getMessage());
            throw new Exception(apiResponse.getMessage());
        }

        return apiResponse.getData();
    }

    private <T> ExternalCommonApiResponse<T> get(Consumer<HttpHeaders> headers, URI uri
            , TypeReference<ExternalCommonApiResponse<T>> typeReference) throws Exception {

        String jsonString = webClient
                .method(HttpMethod.GET)
                .uri(uri)
                .headers(headers)
                .exchangeToMono(res -> res.bodyToMono(String.class))
                .doOnError(e -> {
                    log.error("occurred error while requesting http get - reason: {}" + e.getMessage());
                })
                .timeout(Duration.ofSeconds(TIMEOUT_SEC))
                .block();

        return convertJsonStringToObject(HttpMethod.GET, jsonString, typeReference);
    }

    private <T> ExternalCommonApiResponse<T> post(Consumer<HttpHeaders> headers
            , String baseUrl, String encryptBody, TypeReference<ExternalCommonApiResponse<T>> typeReference) throws Exception {

        String jsonString = webClient
                .method(HttpMethod.POST)
                .uri(baseUrl)
                .headers(headers)
                .body(BodyInserters.fromValue(encryptBody))
                .exchangeToMono(res -> res.bodyToMono(String.class))
                .doOnError(e -> {
                    log.error("occurred error while requesting http post - reason: {}" + e.getMessage());
                })
                .timeout(Duration.ofSeconds(TIMEOUT_SEC))
                .block();


        return convertJsonStringToObject(HttpMethod.POST, jsonString, typeReference);
    }

    private <T> ExternalCommonApiResponse<T> convertJsonStringToObject(HttpMethod httpMethod, String jsonString, TypeReference<ExternalCommonApiResponse<T>> typeReference) throws JsonProcessingException {

        log.info("{} response - body: {}", httpMethod.toString(), jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonObject = objectMapper.readValue(jsonString, JsonNode.class);
        if (!SUCCESS_CODE.equals(jsonObject.get(CODE).asText())) {
            ((ObjectNode) jsonObject).remove(DATA);
        }

        return objectMapper.convertValue(jsonObject, typeReference);
    }
}
