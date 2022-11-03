
insert into config(DOMAIN, CONFIG_KEY, CONFIG_VAL, DETAIL, CREATED_DATETIME)
values('TEST_DOMAIN', 'API_ID', 'test', 'API 통신 헤더 API ID', now());

insert into config(DOMAIN, CONFIG_KEY, CONFIG_VAL, DETAIL, CREATED_DATETIME)
values('TEST_DOMAIN', 'SIGN_KEY', 'test', 'API 통신 헤더 signing 에 필요한 SIGN KEY', now());

insert into config(DOMAIN, CONFIG_KEY, CONFIG_VAL, DETAIL, CREATED_DATETIME)
values('TEST_DOMAIN', 'ENCRYPT_KEY', 'test', 'API 통신 BODY 암호화에 필요한 ENCRYPT KEY', now());

insert into config(DOMAIN, CONFIG_KEY, CONFIG_VAL, DETAIL, CREATED_DATETIME)
values('TEST_DOMAIN', 'IV', 'test', 'API 통신 BODY 암호화에 필요한 IV', now());