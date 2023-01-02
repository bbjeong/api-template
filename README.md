# 외부 API 연동 템플릿
- 외부 API spec 에 대한 request, response, service 를 작성하여 간단하 외부 API를 연동할 수 있는 템플릿
- 
- 패키지 구조 (src/main/java)
  - com.template.web : 최상위 패키지
  - main : 해당 서비스 메인 패키지 (하위에 도메인별 controller, service 포함)
  - common : 해당 서비스 공통 패키지 (constants, domain, enums, utils 등 포함)
  - core.http.api : 해당 서비스 api (공통 response)
  
  - external.api : 외부 API 관련 패키지
  - external.api.constants : 외부 API uri, header, code, field 등 상수값 
  - external.api.domain : 공통 response 인터페이스, 객체
  - external.api.service : 하위에 도메인별 외부 API 용 서비스 
  - external.api.webclient : 외부 API 호출 용도 webclient 서비스 정의


- 프로퍼티 (src/main/resource/)
  - api-domain: 임의의 외부 API 도메인이므로 테스트 불가

     
- api-user.http (test/resources/http)
  - 해당 서비스의 API 테스트 용도

