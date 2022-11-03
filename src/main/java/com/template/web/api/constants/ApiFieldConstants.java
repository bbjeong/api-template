package com.template.web.api.constants;

import lombok.experimental.UtilityClass;

/**
 * API 요청/응답에 대한 필드를 정의
 */
@UtilityClass
public class ApiFieldConstants {

    /* 응답코드 */
    public static final String CODE = "code";
    /* 응답상태 */
    public static final String STATUS = "status";
    /* 응답메세지 */
    public static final String MESSAGE = "message";
    /* 응답데이터 */
    public static final String DATA = "data";

    /* 거래고유ID */
    public static final String TID = "tid";
    /* 회원고유ID */
    public static final String GUID = "guid";
    /* 요청고유번호 */
    public static final String REQ_UNIQ_NO = "req_uniq_no";
    /* 은행코드 */
    public static final String BANK_ID = "bank_id";
    /* 계좌번호 */
    public static final String ACCOUNT_NO = "acnt_no";
    /* 실명 */
    public static final String USER_NAME = "user_name";
    /* 이메일 주소  */
    public static final String USER_EMAIL = "user_email";
    /* 휴대폰 번호  */
    public static final String USER_PHONE_NO = "phone_no";
    /* 생년월일 (yyyyMMdd) */
    public static final String USER_BIRTH_YYYYMMDD = "birth";
    /* CI */
    public static final String MEMBER_CI = "ci";
    /* 유저타입 */
    public static final String USER_TYPE = "user_tp";
    /* 인증타입 */
    public static final String AUTH_TYPE = "auth_tp";
    /* 탈퇴여부 */
    public static final String TERM_YN = "term_yn";
    /* 탈퇴일시 (yyyyMMddHHmmss) */
    public static final String TERM_DATE = "term_dt";
    /* 관리자승인여부 */
    public static final String ADMIN_APPROVE_YN = "adm_appr_yn";
    /* 생성일시 (yyyyMMddHHmmss) */
    public static final String CREATED_DATE = "create_dt";
    /* 사용상태 */
    public static final String USE_STAT = "use_stat";
    /* 사용일시 */
    public static final String USE_DATE = "use_dt";
    /* 통화 */
    public static final String CURR = "curr";

}
