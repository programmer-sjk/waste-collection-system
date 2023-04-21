# 폐기물 관리 시스템

## 개발환경
- 코드 다운로드 후 별도의 DB나 Docker 구동 없이 실행되도록 h2 in-memory DB를 사용
- Spring Boot (3.0.5) + Java 17
- Spring Boot 3.x에선 Java 17버전이 필요, 인텔리제이로 구동하려면 설정을 Java 17로 설정.
    - 참고자료. [인텔리제이 Java 17 버전 구성](https://medium.com/sjk5766/spring-boot-%EB%B2%84%EC%A0%84%EC%97%90-%EB%94%B0%EB%A5%B8-java-%EB%B2%84%EC%A0%84-ff15c5ba7ecb)

## 디렉토리 구조 설명
```text
src
 |--- main
    |--- collection (수거이력, 수거사진)
    |  |--- domain (엔티티, enum, converter)
    |  |--- dto    (request, response dto)
    |  |--- repository (repository 인터페이스)
    |  |--- CollectionController.java
    |  |--- CollectionService.java
    |--- common
    |  |--- BaseEntity.js (엔티티에 공통으로 적용되는 컬럼)
    |  |--- ResponseMessage.js (API 응답에 사용되는 공통 포맷)
    |--- exception
    |  |--- GlobalExceptionHandler.js (글로벌 예외 처리 담당)
    |--- partner_company (업장, collection과 동일한 구조)
    |--- Application.java
 |--- test
    |--- collection 패키지 (collection 관련 기능 테스트)
    |--- fixture 패키지 (테스트에 필요한 엔티티, dto를 생성하는 헬퍼 함수)
    |--- partner_company 패키지 (partner_company 기능 테스트)
```

### 진행하면서 고민했던 순간들
- 연관관계(OneToMany, ManyToOne)를 사용하는게 익숙한데 최근에 최범균님의 도메인 주도 설계 책을 학습하면서 도메인간 의존성을 줄이기 위해 연관관계 대신 id를 참조하는 방식으로 구현
- CRUD에 대한 공통된 메시지를 전달하고 싶어 ResponseMessage 클래스를 사용해 응답.

### 개선해보고 싶은 점
- 연관관계가 없어서 JPQL을 쓰기가 애매했고(JPQL은 객체의 연관관계를 통해 join) QueryDSL에 대한 지식이 없는 상황에서 
repository에 Query 어노테이션으로 실행한 결과를 바로 DTO에 담는 방식으로 구현했지만 Best Practice 같지는 않아서 추후 학습 및 개선
- 처음부터 연관관계 없도록 작성하지 말고, 처음에 연관관계를 맺어서 기능을 만들어보고 이를 연관관계를 제거하고 id로 참조하도록 구현해보고 이후 QueryDSL을 학습해서 구현한다면 더 좋을 것 같음.
