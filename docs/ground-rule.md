# Ground Rule

## Backlog

- 모든 구현 사항에 대해서 백로그로 기록을 남기며 추적할 수 있도록 한다

## Push

1. master 로의 직접적인 push 는 없어야 한다
2. PR Message 의 접두사는 backlog 번호여야 한다.
3. 모든 PR 에 대해서 self-review 를 진행한다. 
4. 모든 push 전에 local build 를 수행한다.

## Test

1. TDD 를 기본으로 한다.
2. 모든 테스트는 항상 통과한다.
3. 테스트 코드는 프로덕션 코드를 설명할 수 있어야 한다.

## 코드

- 클래스는 하나의 액터에 의해서 동작되어야 한다
