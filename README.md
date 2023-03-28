# 외부 API 연동 템플릿
- 외부 API spec에 대한 request, response, service를 작성하여 간단하게 외부 API를 연동할 수 있는 템플릿
- 외부 API 연동 시 공통적으로 필요한 부분을 미리 작성하여 개발 시간 단축

### 사용기술
- Spring Boot 2.7.5
- Spring Web
- Spring JPA

### 패키지 구조 (src/main/java)
- com.template.web : 최상위 패키지
- main : 해당 서비스 메인 패키지 (하위에 도메인별 controller, service 포함)
- common : 해당 서비스 공통 패키지 (constants, domain, enums, utils 등 포함)
- core.http.api : 해당 서비스 api (공통 response)
  
- external.api : 외부 API 관련 패키지
  - constants : 외부 API uri, header, code, field 등의 상수값 
  - domain : 공통 request, response 인터페이스와 각 API별 구현체
  - service : 외부 API용 서비스
  - webclient : 외부 API를 호출하기 위한 webclient 정의

### 프로퍼티 (src/main/resource/)
- api-domain
  - 임의의 외부 API 도메인이므로 테스트 불가
  - 추후 실제 API 도메인으로 변경하여 테스트 가능

### api-user.http (test/resources/http)
- 해당 서비스의 API 테스트 용도

### To Do
1. 연동되는 외부 API 프로젝트 추가 (gradle multi project로 구성할 예정)
2. 외부 API 연동 테스트
3. README.md 구동방법 작성
