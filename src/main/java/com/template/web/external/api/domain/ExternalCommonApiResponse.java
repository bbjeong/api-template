package com.template.web.external.api.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExternalCommonApiResponse<T> {
    private String code;
    private int status;
    private String message;
    private T data;
}
