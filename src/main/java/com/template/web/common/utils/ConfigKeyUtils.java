package com.template.web.common.utils;

import com.template.web.common.domain.entity.ConfigIds;
import lombok.experimental.UtilityClass;

import static com.template.web.common.enums.ConfigDomainEnum.TEST_DOMAIN;
import static com.template.web.common.enums.ConfigKeyEnum.*;

@UtilityClass
public class ConfigKeyUtils {

    public class ApiConfigKey {

        public static ConfigIds CONFIG_API_ID = new ConfigIds(TEST_DOMAIN.name(), API_ID.name());
        public static ConfigIds CONFIG_SIGN_KEY = new ConfigIds(TEST_DOMAIN.name(), SIGN_KEY.name());
        public static ConfigIds CONFIG_ENCRYPT_KEY = new ConfigIds(TEST_DOMAIN.name(), ENCRYPT_KEY.name());
        public static ConfigIds CONFIG_IV = new ConfigIds(TEST_DOMAIN.name(), IV.name());

    }
}
