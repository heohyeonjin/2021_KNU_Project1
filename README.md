# Web-App-Chat-Solution
- "자체 신뢰 기반 전송기술 + FCM푸쉬 솔루션"을 이용하여 웹/앱 간의 상담 채팅 솔루션 제작하였습니다.
- 웹 로그인 방식의 상담 시스템입니다.
- 읽음 처리, 채팅방/채팅목록 실시간 갱신을 통해 실제 채팅 서비스와 흡사한 기능을 구현하였습니다.

``` 고객은 앱을 통해 여러 기업과 채팅 상담이 가능합니다. 특정 기업에 상담 신청을 하게 되면 해당 기업의 상담원이 매칭됩니다. 상담원은 웹 로그인을 통해 여러 창을 띄워 동시에 여러 고객과 상담이 가능합니다. 부가적으로 관리자 페이지를 두어 관리자는 기업, 상담원, 고객을 관리할 수 있도록 하였습니다. ```

# System Diagram

![그림1](https://user-images.githubusercontent.com/72252806/147878301-744c0457-7a37-430c-871a-c7a71b2ec8fd.png)

# Sequence Diagram

![그림2](https://user-images.githubusercontent.com/72252806/147878339-a81f6f09-10b1-4b0e-b239-ee6a6c67f1a5.png)

# 기능 설명

## 메시지 전송
 - 웹(상담원)에서 앱(고객)으로 메시지를 전송할 때는 WebSocket 프로토콜을 사용합니다.
 - 앱(고객)에서 웹(상담원)으로 메시지를 전송할 때는 Google의 푸쉬 서비스인 FCM을 이용하여 메세지를 전송합니다. 이때 schedular를 이용하여 특정 시간 이상 고객으로부터 수신 확인을 받지 못하면 다시 메세지를 전송합니다.
 - 푸쉬 알림을 받으면 해당 기업과의 채팅방으로 화면이 전환되어 바로 원하는 기업과 상담 채팅이 가능합니다.

## 상담원 매칭
 - 기업의 여러 상담원이 존재할 때, 업무의 효율성을 위해 가장 적은 고객과 상담을 하고 있는 상담원이 먼저 고객과 자동 매칭되도록 구현하였습니다.
 
## 비동기 처리 및 읽음 처리
  - polling방식을 이용하여 웹 단의 채팅목록과 채팅방 실시간 처리를 하였습니다.
  - JPA와 TimeStamp를 이용하여 업데이트된 채팅방은 제일 위로 오도록 리스트를 정렬하였습니다.
  - 읽음 처리 기능을 구현하여 고객과 상담원이 각각 메세지 읽음 여부를 확인할 수 있도록 하였습니다.

## 관리자 페이지
  - 모든 기업,상담원,고객을 관리할 수 있는 최고 관리자와 해당 기업의 상담원과 고객을 관리할 수 있는 기업 관리자 두 개로 관리자 페이지 접근 권한을 부여하여 서비스를 관리할 수 있도록 하였습니다.
  - 최고 관리자는 기업과 상담원 등록 및 수정이 가능하고, 모든 고객의 상담 내역 확인이 가능합니다.
  - 기업 관리자는 해당 기업의 상담원 등록 및 수정이 가능하고, 해당 기업 고객의 상담 내역 확인이 가능합니다.

## 최종 결과

### 앱(고객)
![채팅](https://user-images.githubusercontent.com/72252806/147881521-f6b53401-68b0-42fc-9473-1f94804c935f.PNG)

### 웹(상담원)
![web](https://user-images.githubusercontent.com/72252806/147881659-c7fba07b-c2dc-4fb8-b3da-750f0eeb42f2.PNG)

### 관리자 페이지
![관리자페이지](https://user-images.githubusercontent.com/72252806/147881688-ef38c59f-cbc7-4cd1-a480-8391db102921.PNG)


## 기대효과
- FCM 솔루션과 자체 메시징 기술을 통해 중소기업에서 신뢰성 있는 App 자체 상담 서비스를 구축할 수 있음
- App 서비스 분야에 적합한 상담 채팅 기능을 개발함으로써 맞춤 채팅 서비스 형태를 갖출 수 있음

## 시연영상
https://www.youtube.com/watch?v=4U4P2Z3PYUw
