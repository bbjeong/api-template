package com.template.web.core.http.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * HTTP 공통 응답
 */
@Getter
@AllArgsConstructor
public enum HttpCommonResponse implements ApiResponse {
    SUCCESS("0000", 200, "정상"),
    ERROR("9999", 500, "시스템 오류"),
    BAD_REQUEST("H400", 400, "잘못된 요청"),
    UNAUTHORIZED("H401", 401, "권한이 없습니다."),
    NOT_FOUND("H404", 404, "요청하신 정보를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED("H405", 405, "허용되지 않는 메소드");

    private final String code;
    private final int status;
    private final String message;
}
