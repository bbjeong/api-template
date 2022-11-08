package com.template.web.main.service;

import com.template.web.core.http.api.response.CommonErrorResponse;
import com.template.web.external.api.domain.user.GetUserExternalApiResponse;
import com.template.web.external.api.service.user.UserApiService;
import com.template.web.core.http.api.response.ApiCommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserApiService userApiService;

    public ApiCommonResponse getUserDetail(String id) {

        GetUserExternalApiResponse getUserApiResponse;
        try {
            getUserApiResponse = userApiService.getUserDetail(id);
        } catch (Exception e) {
            log.error("failed to get user detail by api - reason: {}", e.getMessage());
            return ApiCommonResponse.fail(CommonErrorResponse.C001);
        }

        return ApiCommonResponse.success(getUserApiResponse);
    }


}
