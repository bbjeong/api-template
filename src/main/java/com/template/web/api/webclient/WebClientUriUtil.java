package com.template.web.api.webclient;

import lombok.experimental.UtilityClass;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@UtilityClass
public class WebClientUriUtil {

    public static URI makeGetUri(URI uri, String path, HashMap<String, String> parameters) {
        String scheme = uri.getScheme();
        String host = uri.getHost();

        MultiValueMap<String, String> queryParams = null;
        if (!ObjectUtils.isEmpty(parameters)) {
            queryParams = new LinkedMultiValueMap<>();
            queryParams.setAll(parameters);
        }

        return UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(path)
                .queryParams(queryParams)
                .build()
                .toUri();
    }

    public static URI makeGetUri(URI uri, String path) {
        return makeGetUri(uri, path, null);
    }
}
