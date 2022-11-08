package com.template.web.external.api.webclient;


import com.template.web.external.api.constants.ApiHeaderConstants;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.function.Consumer;


@UtilityClass
public class WebClientHeaderUtil {

    public static Consumer<HttpHeaders> make(String apiId, String apiSignValue, String reqUniqNo) {
        return httpHeaders -> {
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.add(ApiHeaderConstants.HEADER_API_KEY, apiId);
            httpHeaders.add(ApiHeaderConstants.HEADER_API_SIGN_VALUE, apiSignValue);
            httpHeaders.add(ApiHeaderConstants.HEADER_REQ_UNIQ_NO, reqUniqNo);
        };
    }
}
