# 폐기물 관리 시스템 과제

## 개발환경
- 코드 다운로드 후 별도의 DB나 Docker 구동 없이 실행되도록 h2 in-memory DB를 사용했습니다.
- Spring Boot (3.0.5) + Java 17
- Spring Boot 3.x에선 Java 17버전이 필요합니다. 인텔리제이로 구동하려면 설정을 Java 17로 수정해야 합니다.
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

### 과제하면서 결정에 대한 생각이나 고민했던 순간들
- **kotlin과 java** 중, kotlin도 교육과정에서 사용을 해봤지만 좀 더 숙련도 있는 언어는 Java라고 생각해 java를 선택했습니다.
- 연관관계(OneToMany, ManyToOne)를 사용하는게 익숙한데 최근에 최범균님의 도메인 주도 설계 책을 학습하면서 도메인간 의존성을 줄이기 위해
연관관계 대신 id로 참조한다는 부분을 봤습니다. 익숙한 연관관계를 맺는 방식으로 과제를 할 것이냐. 최근에 학습했지만 좀 부족한 id로 참조할 것이냐 중
연관관계 없이 해보자 라고 결정했습니다.
- 확장자를 enum으로 관리하라는 요구사항에서 과제 요구사항과는 상관없지만 실제로는 수거사진을 저장 및 조회하는 부분이 있을거라고 생각해
converter를 적용해 DB에 저장될땐 소문자로 반대로 DB에서 나올때는 Enum으로 변환되도록 했습니다.
- CRUD에 대한 공통된 메시지를 전달하고 싶어 ResponseMessage 클래스를 사용해 응답하도록 했습니다.
- 1번 요구사항. **업장 이름, 지역, 수거량, 수거 통수를 출력하는 API 개발**에서 한 업장에 수거이력이 많을거라 생각했는데 주어진 데이터로는
일대일로 보여 문의했더니 하나의 방향성을 정하진 않았다고 답변 받았습니다. 업장과 수거이력 데이터가 많다고 가정할 때 특정 업장의 id나 업장명
에 해당하는 여러 수거이력 데이터는 필요하다는 생각이 들어 id를 기반으로 조회하는 API로 만들었습니다.

### 개선해보고 싶은 점
- 연관관계가 없어서 JPQL을 쓰기가 애매했고(JPQL은 객체의 연관관계를 통해 join) QueryDSL에 대한 지식이 없는 상황에서
join이 필요한 조회(1, 2번 요구사항)을 repository에 Query 어노테이션으로 실행한 결과를 바로 DTO에 담는 방식으로 구현했습니다.
헌데 이게 Best Practice 같지는 않아서 추후 이 부분에 대해 좋은 방법이 있는지 학습할 생각입니다.
- 처음부터 연관관계 없도록 작성한걸 후회했는데 처음에 연관관계를 맺어서 기능을 만들어보고 이를 연관관계를 제거하고 id로 참조하도록 구현해보고 이후 
QueryDSL을 학습해서 구현한다면 제 성장에 도움이 되는 지식을 얻을 수 있지 않았을까 생각이 스쳐지나갔습니다. 추후 시간될 때 다시 연관관계를 맺는
걸로 수정해서 위 스텝들을 따라가볼 생각입니다.
