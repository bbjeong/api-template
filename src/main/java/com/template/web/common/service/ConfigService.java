package com.template.web.common.service;

import com.template.web.common.domain.dto.ApiConfig;
import com.template.web.common.domain.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.template.web.common.utils.ConfigKeyUtils.BanknersConfigKey.*;

@Component
@RequiredArgsConstructor
public class ConfigService {

    private final ConfigRepository configRepository;

    public ApiConfig makeApiConfig() {
        String reqUniqNo = "API" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSSSSS"));
        String apiId = configRepository.findByConfigIds(CONFIG_API_ID).orElseThrow().getConfigVal();
        String signKey = configRepository.findByConfigIds(CONFIG_SIGN_KEY).orElseThrow().getConfigVal();
        String encryptKey = configRepository.findByConfigIds(CONFIG_ENCRYPT_KEY).orElseThrow().getConfigVal();
        String iv = configRepository.findByConfigIds(CONFIG_IV).orElseThrow().getConfigVal();
        String merchantGuid = configRepository.findByConfigIds(CONFIG_MERCHANT_GUID).orElseThrow().getConfigVal();

        return new ApiConfig(apiId, signKey, encryptKey, iv, reqUniqNo, merchantGuid);
    }
}
