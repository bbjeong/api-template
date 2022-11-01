package com.template.web.api.webclient;


import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.function.Consumer;

import static com.template.web.api.constants.ApiHeaderConstants.*;


@UtilityClass
public class WebClientHeaderUtil {

    public static Consumer<HttpHeaders> make(String apiId, String apiSignValue, String reqUniqNo) {
        return httpHeaders -> {
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(HEADER_API_KEY, apiId);
            httpHeaders.add(HEADER_API_SIGN_VALUE, apiSignValue);
            httpHeaders.add(HEADER_REQ_UNIQ_NO, reqUniqNo);
        };
    }
}
