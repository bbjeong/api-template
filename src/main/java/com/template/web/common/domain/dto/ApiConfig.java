package com.template.web.common.domain.dto;

import lombok.Getter;

@Getter
public class ApiConfig {

    private String apiId;
    private String signKey;
    private String encryptKey;
    private String iv;

    private String reqUniqNo;


    public ApiConfig(String apiId, String signKey, String encryptKey, String iv, String reqUniqNo) {
        this.apiId = apiId;
        this.signKey = signKey;
        this.encryptKey = encryptKey;
        this.iv = iv;
        this.reqUniqNo = reqUniqNo;
    }
}
