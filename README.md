# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## Step2 : 수강신청(도메인 모델)

### 요구사항
* [x] 과정은 기수 단위로 여러 개의 강의를 가질 수 있다.
* [x] 강의는 시작일과 종료일을 가진다.
  * [x] 시작일 및 종료일을 가진 SessionPeriod를 구현한다.
* [x] 강의는 무료 강의와 유료 강의로 나뉜다.
  * [x] 무료와 유료를 가진 Enum Class인 SessionPaymentType을 구현한다.
* [x] 강의 상태는 준비중, 모집중, 종료 3가지 상태를 가진다.
  * [x] 준비중, 모집중, 종료를 가진 Enum Class인 SessionStatus를 구현한다.
* [x] 강의 수강신청은 강의 상태가 모집중일 때만 가능하다.
  * [x] 강의 신청하는 메서드에 체크로직을 넣는다.
    * [x] 체크 로직은 SessionStatus가 책임을 가진다.
* [x] 강의는 강의 최대 수강 인원을 초과할 수 없다.
  * [x] 수강 인원을 관리하는 SessionStudents 구현한다.
    * [x] 오버되는 학생 수를 체크한다. 
