package com.template.web.external.api.service.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.template.web.external.api.domain.ExternalCommonApiResponse;
import com.template.web.external.api.domain.user.GetUserExternalApiRequest;
import com.template.web.external.api.domain.user.GetUserExternalApiResponse;
import com.template.web.external.api.webclient.WebClientService;
import com.template.web.common.domain.dto.ApiConfig;
import com.template.web.common.service.ConfigService;
import com.template.web.external.api.constants.ApiUriConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 사용자 API
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserApiService {

    private final ConfigService configService;
    private final WebClientService webClientService;

    public GetUserExternalApiResponse getUserDetail(String id) throws Exception {
        ApiConfig config = configService.makeApiConfig();
        TypeReference<ExternalCommonApiResponse<GetUserExternalApiResponse>> typeReference = new TypeReference<>() {
        };
        GetUserExternalApiRequest request = GetUserExternalApiRequest.builder().id(id).build();
        GetUserExternalApiResponse response = webClientService.executeGet(ApiUriConstants.API_GET_USER, request, config, typeReference);
        return response;
    }
}
