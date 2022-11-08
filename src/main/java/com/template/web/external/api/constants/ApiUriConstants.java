package com.template.web.external.api.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiUriConstants {

    private static final String API = "/api";

    /* 회원 조회 */
    public static final String API_GET_USER = API + "/user";
    /* 회원 등록 */
    public static final String API_POST_USER = API + "/user";

}
