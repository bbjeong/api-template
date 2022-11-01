package com.template.web.api.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BanknersCommonApiResponse<T> {
    private String code;
    private int status;
    private String message;
    private T data;
}
