package com.template.web.api.service.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.template.web.api.domain.CommonApiResponse;
import com.template.web.api.domain.user.GetUserApiResponse;
import com.template.web.api.webclient.WebClientService;
import com.template.web.common.domain.dto.ApiConfig;
import com.template.web.common.service.ConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.template.web.api.constants.ApiUriConstants.API_GET_USER;

/**
 * 사용자 API
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class UserApiService {

    private final ConfigService configService;
    private final WebClientService webClientService;


    public GetUserApiResponse getUserDetail() throws Exception {
        ApiConfig config = configService.makeApiConfig();
        TypeReference<CommonApiResponse<GetUserApiResponse>> typeReference = new TypeReference<>() {
        };
        GetUserApiResponse response = webClientService.executeGet(API_GET_USER, config, typeReference);
        return response;
    }
}
