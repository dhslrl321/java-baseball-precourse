# 프로젝트 문서

- [프로젝트 README.md](https://github.com/dhslrl321/java-baseball-precourse/tree/master/docs)
- [backlog](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/backlog.md)
- [ground-rule](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/ground-rule.md)
- [I/O examples](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/example.md)

# JAVA_JIGI Game Land

- 숫자야구 게임

# 기능 요구사항

- 1~9 까지 서로 다른 수로 이루어진 3자리의 수를 맞춘다
    - 스트라이크 : 같은 수가 같은 자리
    - 볼 : 같은 수가 다른 자리
    - 낫싱 : 같은 수가 전혀 없을 경우
- 컴퓨터의 수를 모두 맞추면 승리한다
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시키고 종료되어야 한다.

# 드러나지 않은 요구사항

- 더욱 많은 게임을 포함할 수 있는 형태가 되어야 한다
    - 해당 서비스는 현재 야구 게임만 포함하고 있지만 곧 더 많은 사용자들이 유입될 것으로 보인다.
    - 현재 서비스는 Baseball 이지만 추후에는 게임랜드가 될 수 있다.
      - `GameFinder` 를 통해 새로운 Game 이 추가되더라도 수용할 수 있도록 한다.

# Diagram

## Domain

![domain](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/images/domain.png)

## Domain Modeling

![domain](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/images/domain-modeling.png)

# Backlog

백로그 번호에 따른 Task 를 설명합니다.

- `BL-001`
    - Baseball 에 요구사항을 분석한다.
    - 명확한 요구사항과 드러나지 않은 요구사항에 대해서 각각 정의한다.
- `BL-002`
    - Baseball 에 대해서 도메인 모델링을 한다.
    - 역할과 책임에 따라서 도메인을 나눈다.
- `BL-003`
    - 도메인을 토대로 클래스 설계를 한다.
- `BL-004`
    - Intellij 에 Code-Style 을 적용한다
- `BL-005`
    - Presenter 모듈에 대해서 구현한다.
    - [Github PR](https://github.com/dhslrl321/java-baseball-precourse/pull/1)
- `BL-006`
    - BaseballGame 의 입출력 모듈을 구현한다.
    - [Github PR](https://github.com/dhslrl321/java-baseball-precourse/pull/3)
- `BL-007`
    - BaseballGame 에 대해서 구현한다.
    - [Github PR](https://github.com/dhslrl321/java-baseball-precourse/pull/4)
- `BL-008`
    - BaseballGame 과 Presenter 를 연결한다.
    - [Github PR](https://github.com/dhslrl321/java-baseball-precourse/pull/5)
- `BL-009`
    - BaseballGame 의 리펙토링을 진행한다.
    - [Github PR](https://github.com/dhslrl321/java-baseball-precourse/pull/6)

# 자료

- ### [백로그](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/backlog.md)
- ### [Ground-Rule](https://github.com/dhslrl321/java-baseball-precourse/blob/master/docs/ground-rule.md)