package com.template.web.core.http.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonErrorResponse implements ApiResponse {

    C001(500, "API 통신에 실패하였습니다.");

    private final String code = name();
    private final int status;
    private final String message;
}
