package com.template.web.core.http.api.response;

/**
 * 공통 API 응답을 위한 인터페이스
 */
public interface ApiResponse {

    /* 응답코드 */
    String getCode();

    /* HTTP 상태코드 */
    int getStatus();

    /* 응답 메세지 */
    String getMessage();

    static ApiResponse of(String code, int status, String message) {
        return new ApiResponse() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public int getStatus() {
                return status;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }
}
