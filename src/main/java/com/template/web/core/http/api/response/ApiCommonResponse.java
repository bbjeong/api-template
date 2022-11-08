package com.template.web.core.http.api.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiCommonResponse<T> implements ApiResponse {

    private String code;
    private int status;
    private String message;
    private T data;

    protected ApiCommonResponse(ApiResponse apiResponse) {
        this(apiResponse.getCode(), apiResponse.getStatus(), apiResponse.getMessage(), null);
    }

    public ApiCommonResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    public ApiCommonResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    public static <D> ApiCommonResponse<D> success(D data) {
        ApiCommonResponse<D> response = new ApiCommonResponse<>(HttpCommonResponse.SUCCESS);
        response.data = data;
        return response;
    }

    public static ApiCommonResponse<String> fail(ApiResponse apiResponse) {
        return new ApiCommonResponse<String>(apiResponse).data(null);
    }

    public static ApiCommonResponse<String> error(String message) {
        return new ApiCommonResponse<String>(HttpCommonResponse.ERROR).data(null).message(message);
    }

}