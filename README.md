# SettleUp Project - **service-server (backend)**

## 배포된 웹사이트 : https://d142csekpetioz.cloudfront.net/ 
## 목차 

1.  [🕒 개발 기간 및 팀원](#개발-기간-및-팀원)
2.  [🔧 백엔드 기술 스택](#백엔드-기술-스택)
3.  [📄 서비스 소개](#서비스-소개)
4.  [🔌Structure 설계](#Structrue-설계)
5.  [🔍 핵심 기능 설명](#핵심-기능-추가-설명)
6.  [📈 핵심 기능 추가 설명 - 영수증 등록 (최적화)](#영수증-등록-최적화)
    - [📝 거래원장 생성](#거래원장-생성)
    - [🚀 1차 최적화](#1차-최적화)
    - [💵 순액 구하기](#순액-구하기)
    - [🚀 2차 최적화](#2차-최적화)
    - [🚀 3차 최적화](#3차-최적화)
7.  [🗄️ 데이터 베이스 스키마 구조](#데이터-베이스-스키마-구조)
8.  [💡 구현기능](#구현기능)
9.  [🌱 회고와 성장포인트](#회고와-성장포인트)
    - [📈 API 목적성에 따른 실행흐름 제어](#api-목적성에-따른-실행흐름-제어)
    - [🔄 재사용성](#재사용성)
    - [🔌 인터페이스 기반 프로그래밍](#인터페이스-기반-프로그래밍)
    - [🚀 배포의 자동화](#배포의-자동화)
    - [🔒 보안](#보안)
    - [🧠 체계적인 작업과 스스로 묻고 답하기](#체계적인-작업과-스스로-묻고-답하기)
10.  [💡 시연영상](#시연영상)
11.  [🤝 협업툴](#협업툴)


------------------------------------------------------------------

## 🕒 <a name="개발-기간-및-팀원"></a>개발 기간 및 팀원
 **개발기간** : 2024. 2. 19 ~ 2024. 7.12 </br>
 **회의시간** : 오전 9시 , 오후 9시 </br>
 **팀원소개**
|분야 | 담당자 | 홈페이지 |
| --- | --- |---|
|**Backend**  | 서동희 | <a href="https://github.com/donghee9"><img src="https://img.shields.io/badge/GitHub-007396?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/donghee9"/></a></br>
|Frontend| 박수빈 |<a href="https://github.com/sooparkdev"><img src="https://img.shields.io/badge/GitHub-ED8B00?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/donghee9"/></a></br>


---------------------------------------------------------------------

## 🔧 <a name="백엔드-기술-스택"></a>백엔드 기술 스택

| 분야          | 기술스택                                                                                                   |
|--------------|----------------------------------------------------------------------------------------------------------|
| 언어         | ![Java_corretto_17](https://img.shields.io/badge/Java_corretto_17-007396?style=flat-square&logo=java&logoColor=white) ![Shell](https://img.shields.io/badge/Shell-A5DD9B?style=flat-square&logo=Shell&logoColor=white)        |
| 프레임워크   | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=spring&logoColor=white) |
| 데이터베이스 | ![MySQL](https://img.shields.io/badge/MySQL-59B4C3?style=flat-square&logo=MySQL&logoColor=white)                                                |
| ORM          | ![JPA](https://img.shields.io/badge/JPA-59666C?style=flat-square&logo=hibernate&logoColor=white)                                               |
| 메모리       | ![Redis](https://img.shields.io/badge/Redis-EE4266?style=flat-square&logo=Redis&logoColor=white)                                               |
| 배포         | ![GithubAction](https://img.shields.io/badge/GithubAction-EE4266?style=flat-square&logo=Github&logoColor=white) ![AWS](https://img.shields.io/badge/AWS-FF6631?style=flat-square&logo=AWS&logoColor=white) ![CodeDeploy](https://img.shields.io/badge/CodeDeploy-006400?style=flat-square&logo=AWS&logoColor=white) ![EC2](https://img.shields.io/badge/EC2-FF6600?style=flat-square&logo=EC2&logoColor=white) ![S3](https://img.shields.io/badge/S3-A5DD9B?style=flat-square&logo=S3&logoColor=white) ![Azure](https://img.shields.io/badge/Azure-0078D4?style=flat-square&logo=microsoft&logoColor=white)        |
| 외부 툴      | ![Sentry](https://img.shields.io/badge/Sentry-EE4266?style=flat-square&logo=Sentry&logoColor=white) ![ngrok](https://img.shields.io/badge/ngrok-1F1E25?style=flat-square&logo=ngrok&logoColor=white)                       |
| 로깅         | ![Log4j](https://img.shields.io/badge/Log4j-FF4500?style=flat-square&logo=apache&logoColor=white)                                              |
| ****알고리즘****    | ![Graph Algorithm](https://img.shields.io/badge/Graph_Algorithm-2E8B57?style=flat-square&logo=graph&logoColor=white) ![DFS](https://img.shields.io/badge/DFS-8B0000?style=flat-square&logo=dfs&logoColor=white) ![Sorting Algorithm](https://img.shields.io/badge/Sorting_Algorithm-4682B4?style=flat-square&logo=sorting&logoColor=white) ![AES Encryption](https://img.shields.io/badge/AES_Encryption-4B0082?style=flat-square&logo=aes&logoColor=white)|
| 보안         | ![OAuth2](https://img.shields.io/badge/OAuth2-4285F4?style=flat-square&logo=oauth&logoColor=white) ![BCrypt](https://img.shields.io/badge/BCrypt-FF4500?style=flat-square&logo=security&logoColor=white) |
| 테스트       | ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white) ![Mockito](https://img.shields.io/badge/Mockito-9F00C5?style=flat-square&logo=mockito&logoColor=white) |
| 유틸리티     | ![p6spy](https://img.shields.io/badge/p6spy-00ACC1?style=flat-square&logo=database&logoColor=white) ![JWT](https://img.shields.io/badge/JWT-ED8B00?style=flat-square&logo=json-web-tokens&logoColor=white) ![JAXB](https://img.shields.io/badge/JAXB-9C27B0?style=flat-square&logo=java&logoColor=white) ![Embedded Tomcat](https://img.shields.io/badge/Embedded_Tomcat-FF6F00?style=flat-square&logo=apache-tomcat&logoColor=white) ![Embedded Redis](https://img.shields.io/badge/Embedded_Redis-DC143C?style=flat-square&logo=redis&logoColor=white) ![Mail](https://img.shields.io/badge/Mail-D14836?style=flat-square&logo=gmail&logoColor=white) |

-------------------------------------------------------------------------------------

## 📄  <a name="서비스-소개"></a>서비스 소개 </br>
저희 서비스는 그룹 내 공유 정산서 기능을 제공합니다. 특히 장기간에 걸쳐 자주 발생하는 지출이 있는 경우(룸메이트, 장기 여행자, 정기 모임 등)에 초점을 맞추고 있습니다. 이런 상황에서는 각 거래 후 바로 정산하지 않으면, 시간이 지나면서 누가 누구에게 얼마나 채무가 있는지 파악하기 어려워집니다. 저희 시스템은 이를 해결하기 위해 개발되었습니다.</br>

SettleUp 서비스를 통해 사용자는 영수증 사진을 간편하게 등록할 수 있습니다.</br> 이렇게 쌓인 비용은 최적화 자료에 따라 언제든지 유저가 원하는 시기에 개인적으로 송금하고, 그 결과는 그룹 전체에 반영됩니다. 장기간 비용이 발생하는 모임에서, 모든 거래를 추적할 필요 없이 저희 시스템은 그룹 내 채무 관계를 알고리즘으로 재조정하여 최소한의 거래 횟수를 요구합니다.</br>

저희 사이트는 장기간 발생한 비용으로 인해 복잡해진 채무 관계를 단순화하여,</br> 사용자가 받아야 할 금액과 지불해야 할 금액을 명확하게 제시합니다. 이 기능이 저희 서비스의 핵심입니다.</br>

-------------------------------------
## 📄  <a name="Structrue-설계"></a> 🔌 Structure 설계</br>

### 도메인 주도 설계 (DDD)와 MVC 패턴으로 설계


아래는 DDD와 MVC 패턴을 적용한 설계 구조에 대한 간략한 설명입니다.

#### Domain


| Domain        | 설명                                                                                   |
|---------------|----------------------------------------------------------------------------------------|
| **User**      | 사용자 정보 관련, 로그인/로그아웃, 유저 검색 등                                        |
| **Group**     | 그룹 생성, 그룹 탈퇴, 월별 보고서 신청, 그룹 초대, 그룹 내 유저 개인화 정보 불러오기 등 |
| **Receipt**   | 영수증 등록, 최적화, 영수증 사진 텍스트로 파싱 등                                     |
| **Transaction** | 타인이 나에게 송금한 내역 불러오기, 타인이 나에게 송금한 내역 반영 등               |


#### Global
전역적으로 사용되는 공통 모듈 및 설정은 다음과 같이 관리됩니다.

| Global Module | 설명                                                                                         |
|---------------|----------------------------------------------------------------------------------------------|
| **common**    | 응답 데이터, 외부 API 호출, Status 등 모듈화로 관리                                          |
| **config**    | 보안이 필요한 정보를 외부에서 객체로 불러올 수 있도록 각각 모듈화                            |
| **event**     | 이벤트, 이벤트 리스너 정의                                                                   |
| **exception** | `CustomException`, `ErrorCode`, `globalErrorHandler`, 비동기 에러 핸들러 모듈로 관리         |
| **util**      | JWT 생성/파싱, AES 암호화 생성/관리, `JwtVerificationFilter`로 전역적 관리 도모             |

이와 같이 DDD와 MVC 패턴을 결합하여 설계하면 도메인 중심의 명확한 구조와 각 모듈의 역할 분리를 통해 유지보수성과 확장성을 높일 수 있도록 하였습니다


-----------------------------------------------------------------------------------------

## 🔍 <a name="핵심-기능-추가-설명"></a>핵심 기능 설명</br>
```
1. 기능설명
2. 전체적인 시스템 유저플로우
3. 핵심기능인 영수증 등록 플로우
``` 
<u>**기능설명**</u> </br>
실제 영수증을 기반으로 거래를 추적하여 투명한 최적화를 제공합니다. </br></br>
사용자는 영수증 사진을 업로드하기만 하면,</br> 그룹 내 특정 인원을 아이템별로 선택해 각 금액을 할당하고, 서버에서 최적화를 통해 얽힌 채무 관계를 재조정할 수 있습니다.</br></br>
일부 송금이 완료되면 보낸 유저는 그 금액을 체크하고, 받는 유저는 페이지에 접속했을 때 누구에게 얼마를 받았는지 확인할 수 있습니다.</br>
또한, 그룹 내 비용 발생의 시작점이 되는 영수증은 날짜별로 유저가 추적할 수 있도록 설계했습니다.

아래는 전반적인 서비스의 유저플로우와 핵심기능의 유저 플로우 입니다 

<u>**A. 전체적인 시스템 유저 플로우**</u>
![스크린샷 2024-05-02 오후 4 30 54](https://github.com/Settle-Up/settle-up-server/assets/129722492/cd36737b-bb88-44b2-9f8b-56d3ed0d0250)

<u>**B. 핵심기능인 영수증 등록 플로우**</u>
![스크린샷 2024-05-11 오후 8 44 59](https://github.com/Settle-Up/settle-up-server/assets/129722492/9834ec7f-3ece-4fca-98e0-f4095dd1c940)

대부분의 기능은 개발일지에 개발 과정과 유저플로우를 추가로 설명해 놓았습니다 </br>
하지만 핵심 기능인 영수증 업로드시 최적화 하는 과정은 저희 서비스를 이해하시는데 밀접하게 연관이 있다고 판단하여 </br>
본문 readme 에 포함 시켜 설명드리고자 합니다 

-------------------------------------------------------------------------

## 📈  <a name="영수증-등록-최적화"></a>영수증 등록 (최적화)
```
1. 유저 플로우
2. 비용 생성 과정
3. 영수증에 대한 정규화 형식
4. 영수증 등록 후 최적화 과정 
	- 거래원장 생성
 	- 1차 최적화 
 	- 순액 구하기
 	- 2차 최적화 
 	- 3차 최적화 
```

### 유저 플로우 
1. 유저가 영수증을 업로드 
2. 프론트엔드에서 영수증을 사진을 서버에게 보내는 요청
3. 서버는 그 영수증 사진을 을 기반으로 외부 azure api 를 호출합니다
4. 서버는 azure api 응답 값을 프론트엔드에게 전달합니다
5. 프론트엔드에서는 정해진 형식에 따라 데이터를 가공하여 서버에게 두번째 요청을 보내게 됩니다 
6. 서버는 두번째 요청에 의해 영수증을 저장하고 최적화하여 비용을 등록합니다
7. 서버는 프론트엔드에게 성공 또는 에러 메세지를 도출합니다


해당 글에서는 위의 5번 이후의 과정인 가공된 영수증을 받아 영수증 저장에 성공한 뒤 최적화 하는 과정에 대해 자세히 서술하고자 합니다 
앞단의 azure api 를 호출하는 과정은 "개발일지"에 영수증 외부 api 호출.md 에 설명이 있습니다

![스크린샷 2024-05-11 오후 8 47 42](https://github.com/Settle-Up/settle-up-server/assets/129722492/4d76853c-b010-4ef5-9191-9a26b592b254)

그림으로 보시면 B의 과정입니다 

--------------------------------------------
### 비용 생성 과정

저희 서비스의 최대 목적은 그룹 내 여러번의 송금이 쌓이고 그 그룹 내에서 얽혀 있는 채무 관계를 단순화 하는 것이 목표였습니다
그러기 위해서는 먼저 영수증으로 부터 얻은 비용이 "어떻게" 할당 되는지 문제가 우선이 였습니다 

실제로 이루어지는 그룹간의 거래 관계를 반영하기 위해 저희가 더치페이를 할 때 가정하는 상황들을 나열하고 
영수증을 통해 분할은 크게 두가지로 이루어진다는 것에 합의에 도달했습니다

가정은 두가지로 나뉩니다 </br></br>
C1) 아이템 **균등분할** </br> 구성원이 아이템 마다 인원 수 대로 1/n 을 하는 경우와 </br></br>
C2) 아이템 **차등분할** </br> 각각의 구성원이 아이템마다 구매한 아이템 갯수가 달라서 아이템마다 다르게 할당하는 경우입니다 </br>

영수증을 토대로 저희는 
영수증과  상세 내용, 각 유저 관계를 저장을 해야 했으며 
-  receipt : 영수증의 기본적인 내용을 담은 테이블 
-  receipt_item : 영수증 기본내용과 아이템을 이어주는 테이블
-  receipt_item_user: 영수증 아이템과 유저의 관계를 풀어 줄 테이블

위와 같이 3가지 테이블이 필요하다고 판단하였습니다

영수증을 산출하는데 있어서 비용선택 과정이 위의 설명처럼 두가지 케이스로 분류 되는 이유에 대해 설명드리고자
자세한 예를 들어 A, B , C  로 구성이 되어 있는 그룹의 일회성 영수증을 통한 유저 플로우를 살펴보겠습니다 

1번 째 영수증에서 A가 34,000원의 타코집에서 돈을 쓰고 
구성원은 A , B , C 였습니다 
내역은 다음과 같습니다

| 상품명(아이템) | 갯수 | 개당 가격 | 총 가격 |
|---------------|------|-----------|---------|
| 가 타코        | 2    | 5,000     | 10,000  |
| 나 타코        | 3    | 5,000     | 15,000  |
| 다 맥주        | 3    | 3,000     | 9,000   |


이런 영수증을 토대로  유저는 
각각 아이템 마다 균등분할 또는 차등분할을 할지 선택할 수 있는 선지가 주어집니다 

**"차등 분할(variableQuantity)"** 을 선택한다는 가정을 한다면 

| 상품명(아이템) | 갯수 | 개당 가격 | 총 가격 | 참여구성원 | 구매한 갯수 |
|---------------|------|-----------|---------|------------|------|
| 가 타코        | 2    | 5,000     | 10,000  | B          | 2    |
| 나 타코        | 3    | 5,000     | 15,000  | A          | 2    |
|               |      |           |         | C          | 1    |
| 다 맥주        | 3    | 3,000     | 9,000   | C          | 2    |
|               |      |           |         | A          | 1    |

                                 
이런식으로 같은 아이템이라도 각 구성원이 아이템 구매 갯수에 차등을 둘 수 있도록 했습니다 


**"균등분할(EqualQuantity)"** 을 선택한다는 가정을 한다면 

| 상품명(아이템) | 갯수 | 개당 가격 | 총 가격 | 참여 구성원 |
|---------------|------|-----------|---------|------------|
| 가 타코        | 2    | 5,000     | 10,000  | B          |
| 나 타코        | 3    | 5,000     | 15,000  | A, C       |
| 다 맥주        | 3    | 3,000     | 9,000   | A, C       |

위와 같이 선택할 수 있도록 하였습니다 

--------------------------------------

### 영수증에 대한 우리 사이트의 정규화된 형식
```
{
  "receiptName": "영수증이름",
  "address": "영수증 주소", 
  "receiptDate": "YYYY-MM-DD", // 실제 날짜 값으로 대체 필요. 예: "2024-02-25"
  "groupId": "그룹 고유 식별자",
  "groupName": "그룹 이름",
  "payerUserId": "결제자 사용자 고유 식별자",
  "payerUserName": "결제자 이름",
  "allocationType":"variableQuantity",
  "totalPrice": "총 가격", // 예: "10000"
  "discountApplied": "적용된 할인액", // 예: "500"
  "actualPaidPrice": "실제 지불 금액", // 예: "9500"
  "receiptItemList": [
    {
      "receiptItemName": "사과",
	    "totaltemQuantity":" ",
			"unitPrice":"",
      "jointPurchaserCount": "4", // 아이템마다 각자 배분 하더라도 총 아이템에 사는데 기여한 사람의 수
      "jointPurchaserList": [
        {
          "userId": "사용자1 고유 식별자",,
          "purchasedQuantity": "3"
        },
        {
          "userId": "사용자2 고유 식별자",
          "itemQuantity": "1"
        }
      ]
    }
  ]
}
```
위와 같이 영수증을 재구성하는데 있어서 필요한 기본 내용과 각 유저마다 할당된 비용을 집계하기 위한 json 형식으로 프론트와 백엔드에서 소통을 하기로 협의를 하였습니다 
형식에서 필수 부분이 빠지거나 (영수증 이름 , 주소 , 날짜 , 그룹 , 결제자정보 , 배분타입 , 총가격 , 할인여부 , 영수증 리스트) </br> 
총 합계 계산이 올바르지 않거나 (개당 가격 * 갯수  and 아이템당 구매인원이 구매한 갯수의 가격 둘다 포함)  </br>
배열을 가령 참여자는 3명이라고 했는데 , 참여자를 나타내는 배열이 부족하면 (JointPurchaserCount 만큼 유저 리스트가 생성되어 와야함)</br>
controller 에서 유효성 검사로 어느 부분 필드가 누락 되었는지 메세지로 프론트에 알려줄 수 있도록 설계 하였습니다

---------------------------------------------------------------------------------------

### 영수증 등록 후 최적화 과정 

최적화 과정은 service에서 영수증이 데이터 베이스에 저장이된 후 controller 로 반환값을 전달하고 </br>
**응답 메세지 인스턴스를 만들기 직전에 이벤트를 발행하여** , **리스너가 발행한 이벤트를 감지하고 최적화 과정들을 호출합니다**

이렇게 설계한 이유는 유저의 입장에서 "영수증 등록"이라는 과정이 서버에서 영수증 내용을 저장하고 난 이후의 로직상 서버 에러는 유저나 프론트에서 불필요한 메세지로 느껴져서 
최적화 과정에서 나오는 exception의 경우 sentry 를 이용하여 서버에 등록된 이메일과 디스코드로 메세지를 보낼 수 있게 하여 서버작업자가 모니터링 할 수 있도록 설계하였습니다 

리스너의 호출로 인하여 최적화 과정은
크게 5가지 과정으로 이루어 집니다 

- **거래원장 생성 (RequireTransaction)** :</br> 등록된 영수증을 각각의 보낼 돈이 있는 사람마다 payer 와 recipent 간의 채무관계 설정하기 
-**1차 최적화 (OptimizedTransaction)** :</br> 그룹 내 모든 거래관계에서 개인간의 거래가 중복되면 1개의 거래로 최적화하기 
- **순액 구하기 (net)**:</br> 그룹 내 각 유저의 받거나, 줘야할 돈을 합산한 순수하게 내가 받거나 줘야할 돈 계산 
- **2차 최적화 (groupOptimizedTransaction)** :</br> 거래의 흐름이 같은 금액이 계속된다면 (A->(500)-> B , B->(500)-> C 결과적으로 A는 C에게 500원을 주면됌 ) 새로운 거래 생성하기 
- **3차 최적화 (UltimateTransaction)**:</br> 새로운 거래의 생성으로 개인간의 거래가 중복될 수 있는 가능성을 고려해 , 개인간의 거래 다시 1개로 최적화 
	
----------------------------------------------------------------------------

### <a name="거래원장-생성"></a>  step 1)📝 거래 원장 생성 (RequireTransaction)

#### 목적:
영수증을 등록한 뒤에 대표로 돈을 낸 사람에게 
빚진 유저가 자신이 구매한 아이템 가격과 아이템 갯수를 토대로 줘야할 돈을 기록하는 용도입니다

#### 개발시 고려사항:
저희는 균등배분과 , 차등배분으로 유저에게 아이템 마다 가격을 배분하는 자율성을 주기로 하였습니다 
이에 균등 배분 , 차등 배분 시 들어와야 할 필드 값은 다르지만 각각의 경우에 코드를 이분화하면 중복되는 코드가 너무 많아 두 가지 경우 모두 포함 할 수 있는 코드로 작성했습니다 

--------------------

### <a name="1차-최적화"></a>step 2)🚀 1차 최적화 (OptimizedTransaction)

#### 목적 :
그룹 내 두명의 유저가 형성할 수 있는 거래 횟수를 1번 또는 0 번으로 최적화하는 과정입니다 
그룹이 A,B,C,D,E 라는 구성원이 있다면 
A-B ,A-C ,A-D ,A-E ,B-C ,B-D ,B-E ,C-D ,C-E ,D-E
의 관계에서 일어날 수 있는 여러번의 거래를 한번으로 최적화하는 것이 기본적인 최소화라고 고려했습니다 

이에 영수증이 추가 될때 마다 무조건 적으로 이벤트 리스너의 호출을 받아 거래 원장을 생성하고 , 1차 최적화 과정에 들어 갑니다 

#### 개발방법:
1. 그룹 내 인원이 2명이서 이룰 수 있는 관계를 정의 : 조합 (combination) 이라는 수학 공식을 이용해 2명이서 이룰 수 있는 관계를 리스트화 하였습니다 
2. combinationList 생성 [A,B][A,C][A,D][A,E][B,C][B,E][C,D][C,D][C,E][D,E]
3. combinationList 를 토대로 requireTransaction 에서 sender(채무자) 와 reciptent(채권자) 관계를 형성하는 것을 찾음
4. 채무자와 채권자의 관계에서 combiationList 의 배열 [0]이 sender 일 경우 totalAmount 에 금액을 차감하고 , reciptent 일 경우 totalAmount 에 금액을 더하는 식으로 loop 문 실행
5. 최종적으로 나온금액이 " 0 "이라면 새로운 거래를 생성하지 않고 requireTransaction 에 최적화과정 중 상속에 의한 거래 clear
6. 최종적으로 나온금액이 - 라면 combinationList 의 배열 [0]을 reciptent , 배열 [1]을 sender 로 하고 + 라면 그 반대로 거래를 생성
7. OptimizedTransaction 엔티티에 저장
   
------------------------------------------------------------------

### <a name="순액-구하기"></a>step 3) 💵 순액 구하기 (net)

#### 목적 :
그룹내 각 유저가 영수증을 추가한 현재시점에 타인에게 받아야할 돈 또는 타인에게 주어야 할 돈의 순액을 구하기 위한 로직
2차 최적화 시 DFS 를 도는 기반이 되고 , 2차 , 3차 최적화시 로직 오류로 송금관계가 꼬일 경우를 대비하여 증명을 위해 둔 장치

-----------------------------------------------------------------------

### <a name="2차-최적화"></a>step 4)🚀 2차 최적화 (groupOptimizedTransaction)

#### 목적 :
개인간의 거래는 한개로 최소화되었지만 아래와 같은 경우를 고려했습니다
<img width="823" alt="스크린샷 2024-05-12 오후 9 09 44" src="https://github.com/Settle-Up/settle-up-server/assets/129722492/feda16b1-0577-4789-8369-167ebdd86cc2">

가) 상황을 보면 각유저는 1차 최적화 결과 다른 유저와 한개의 거래만을 형성하고 있습니다 
하지만 저희 서비스는 그룹 내"최소송금" 방안을 제안드리기 위해
나)와 같이 가중치가 같은데 연속되는 경우에 집중했습니다 

A->C->E->D 의 경우에 A 가 바로 D에게 만원을 송금하면 3번의 송금이 줄어 들어 그룹내 이익이 커질 것이라고 판단하였습니다 
이에 2차 최적화를 진행하기로 했습니다 

#### 개발방법:
그래프 알고리즘 과 DFS 활용
1. 먼저 그룹 내 개인을 **"노드"** 라는 개념으로 보기로 했습니다</br>
2. **DFS 설계원칙**
   - DFS 시작점을 어떤 노드로 할지에 대한 점에서는 순액에 따라 빚이 가장 많은 사람 부터 도는 방식을 선택했습니다 , 만약 빚이 같은 사람이 있다면 유저의 Fk 의 순서가 숫자가 작은 사람 부터 돌도록 하였습니다
   - 이전 가중치와 현재가중치가 같다면 , 새로운 가중치가 나오기 전까지 방문배열에 기록을 하고 가중치가 달라지면 이전에 기록해두었던 배열의 시작과 끝을 노드로 하여 새로운 엣지를 만드는 방식을 선택했습니다
3.**그래프 알고리즘 설계 원칙** 
   - 그래프를 구성하기 위해 JGraph T 라이브러리를 활용 
   - Vertex(정점)을 senderId 와 reciptentId 로 지정
   - Edge 에는 가중치(총금액)과 거래 아이디가 들어가야하는 상화 하지만 해당 라이브러리기능은 엣지에 두가지 정보를 한번에 넣을 수 없으므로 OOP 원칙에 따라 graph 와 엣지의 정보를 담는 객체를 생성하여 값을 도출
4. **설계 시 신경쓴 부분**
   - createGraphFromTransactions 메소드는 객체지향 프로그래밍(OOP)의 핵심 원칙을 적용하여 개발된 기능입니다.
     특히, 캡슐화와 추상화 원칙을 활용하여, 거래 데이터를 그래프의 형태로 변환하고 이를 다루기 위한 복잡한 로직을 숨겨, 외부에서는 간단하게 그래프 객체를 통해 거래 관계와 흐름을 조작할 수 있게 합니다
     
--------------------------------------------------------------------

### <a name="3차-최적화"></a>step 5)🚀 3차 최적화 (UltimateTransaction)

#### 목적:
2차 최적화가 일어난다면 아래와 같이 거래 관계가 변동이 있을 것입니다 
<img width="881" alt="스크린샷 2024-05-12 오후 9 53 56" src="https://github.com/Settle-Up/settle-up-server/assets/129722492/71ae7529-efdb-42c6-ad76-b0b6b3e73ac6">

다) 의 경우 2차 최적화로 인한 결과입니다 
A 와 D 사이에 중복되는 거래가 생성된 것을 볼 수 있습니다 

**이런 경우를 대비하여 "2차 최적화로 인해 새로운 에지가 형성이 된다면" 3차 최적화가 호출이 될 수 있도록 설계하였습니다 
만약 가중치가 연속되는 것이 없어서 2차 최적화로 인한 결과가 생성이 되지 않는다면 , 중첩되는 거래를 없을 것이며 이럴 경우 3차 최적화를 호출하는 것은 메모리의 낭비라고 생각했기 때문입니다**

3차 최적화의 경우 1차 최적화와 비슷한 방식으로 조합이라는 수학공식을 이용해 그룹내 두 유저간의 관계 형성 후 
1. 1차 최적화 결과 - 2차 최적화를 위해 쓰인 1차 최적화 거래 제외
2. 2차 최적화 결과 
1 번 2번을 추합하여 대상을 좁히고 두 유저간의 하나의 거래만이 생성되도록 채무 관계를 재조정 합니다

--------------------------------------------------------------------------------

## 💡 <a name="구현기능"></a>구현기능

개발기간동안 총 아래와 같이 21개의 api를 개발하였습니다 </br>
개발은 공동으로 하는 작업이므로 제 코드를 남이 이해할 수 있도록 구성하는것도 중요한 업무 능력 중 하나라고 생각이 됩니다 </br>
최대한 **구조화 , 캡슐화하여 복잡한 비지니스 로직은 은닉화 하여 가독성**을 높였으나 </br>
**코드만으로는 제가 고민했던 흔적들을 다 남길 수 없다는 아쉬움**에 개발 시에 여러 고민을 한 기능들에 한해 따로 **개발일지** 파일을 만들어 설명을 제공합니다 </br>
내용이 방대한 점을 고려하여, 혼란을 줄이고 가독성을 높이기 위해 본문에 포함 시키지 않았습니다</br>

번거로우시더라도 해당 파일을 코드를 살펴 보시기 전에 검토하시면 시스템에 대한 더 명확한 이해를 제공해 드릴 수 있습니다

아래는 개발한 기능들 분류와 기능 , 간단한 부연 설명과 해당 기능들에 대한 Http 메서드와 엔드포인트 내역입니다  

| **번호** |  **분류**  | **기능& readme파일명**  |  **부연설명**                    |  HTTP Method & EndPoint                           | 
|----|-------|---------------------------|----------------------------------|---------------------------------------------------|
| 1       | 보안&인증 | 소셜로그인    | 카카오 소셜 로그인                   | **GET** /auth/login/social/kakao?code={code}   | 
| 2       | 보안&인증 | 토큰 검증     | 토큰 검증       | **GET** /auth/checkToken                      |  
| 3       | 보안&인증 | 로그아웃      | 레디스 활용 블랙리스트 기법    | **GET** /logout        |  
| 4       | 검색        | 이메일 검색  | 그룹 생성시 멤버를 추가하기 위한 검색    | **GET** /users/search?email={email}&page={page}&size={size}  |  
| 5       | 검색         | 이메일 검색   | 기존 그룹에 멤버를 추가하기 위한 검색    | **GET** /users/search?email={email}&page={page}&size={size}&excludeGroupId={groupId} |
| 6       | 그룹        | 그룹생성          | 비용그룹을 생성                    | **POST** /groups |  
| 7       | 그룹        | 그룹 리스트 불러오기| 유저가 포함된 그룹과 각각의 순액 불러오기| **GET** /groups?page={page}&size={size}|   
| 8       | 그룹        | 그룹 내 유저 개인화 정보 불러오기 | 거래잔액 , 정산해야할 목록 , 지난주에 정산된 거래목록 , 그룹 내 알람 설정등 | **GET**  /groups/{groupId}?page={page}&size={size} | 
| 9       | 그룹        | 그룹 내 모든 지출보기| 그룹 내에서 발생한 모든 영수증 지출내역 보기 |**GET** /groups/{groupID}/expenses?page={page}&size={size} | 
| 10      | 그룹        | 특정 지출 내역 상세 정보 불러오기| 그룹내에서 발생한 특정 지출에 대한 정보 보기 | **GET** /groups/{groupID}/expenses?page={page}&size={size} | 
| 11      | 그룹        | 멤버 불러오기 | 그룹 내의 유저 정보 불러오기 | **GET** /groups/{groupId}/members?page={page}&size={size} | 
| 12      | 그룹        | 월간 보고서 신청| 그룹 내 개별 사용자가 월간 보고서를 이메일로 송부 받을지 여부 |**PATCH** /groups/{groupId}/monthly-reports |  
| 13      | 그룹        | 그룹 탈퇴 | 그룹에서 탈퇴 |**DELETE** /groups/{groupId}/monthly-reports | 
| 14      | 그룹        | 그룹 멤버 추가 | 기존 그룹에 멤버 추가시 이메일 발송 | **POST** /groups/{groupId}/members 
| 15      | 비용     | 그룹 지출 내역 생성 | 영수증 데이터를 통한 지출 내역 생성 |  **POST** /expense | 
| 16      | 거래  | 송금내역확인창| 타인에게서 송금받은 알림 | **PATCH** transactions/{transactionId}/manage |   
| 17      | 거래  | 송금내역 불러오기 | 타인에게서 송금 받은 내역 불러오기 | **GET** transactions/received |  
| 18      | 사용자| 사용자 정보 불러오기 | 사용자 정보 불러오기 | **GET** /users/profile |  
| 19      | 사용자| 사용자 정보 수정| 사용자 정보 수정 | **POST** /users/profile  |   
| 20      | 영수증       | Azure api 호출 | Azure Doc intelligence 를 통해 영수증사진에서 텍스트 추출 | **POST** /receipt/extract-text | 
| 21      | 헬스체크| health-check | 네트워크 정상 커넥션 확인 엔드포인트 | **GET** /auth/check/connection/brower | 
|         | 에러핸들링 | 모듈화 에러핸들링 | 모듈화로 재사용성을 높인 에러핸들링 |  |
|         | CI/CD      | CI/CD 도입기 | githubAction, AWS,S3,EC2,Script 를 사용한 자동배포 도입기 | | 
|         | 추후 개선사항 | 추후 개선사항 | 고도화를 시키고 싶은 작업과 그 이유 | | 

위의 표 중 15 번 그룹 지출 내역 생성은 본문에 포함시켜 놓았으므로 따로 개발일지에 넣지 않았습니다 참고 부탁드립니다

 ---------------------------------------------------- 

## <a name="데이터-베이스-스키마-구조"></a>🗄️ 데이터 베이스 스키마 구조 
![스크린샷 2024-05-13 오전 11 22 26](https://github.com/Settle-Up/settle-up-server/assets/129722492/2a9fcfe4-ed98-4a12-884b-bacf073d0b2d)

-------------------------------------------------------------
##  <a name="회고와-성장포인트"></a>🌱 회고와 성장포인트
```
1. 회고 
2. 성장 포인트
	- api 목적성에 따른 실행 흐름의 제어
	- 재사용성
	- 인터페이스 기반 프로그래밍
	- 배포의 자동화 
	- 보안 
	- 체계적인 작업과 스스로 묻고 답하기
```

### 🌱 회고 </br>
본 프로젝트는 백엔드 한명 , 프론트 한명이서 개발한 프로그램이였습니다 
즉 각자의 파트에서 처음부터 끝까지 웹사이트를 기획하고 프로그래밍으로 실현해서 결과를 확인 할수 있어서 개발에 대한 시야를 넓힐 수 있는 좋은 기회였습니다 

하지만 , 그만큼 혼자서 모든 기능을 구현하는 과정이 쉽지는 않았던거 같습니다 
서버의 모든 것을 혼자 개발 하다보니 , 이 프로젝트의 서버 자체가 현재 백엔드를 개발하는 나의 실력을 정확하게 나타내는 지표라는 생각을 했습니다</br> 
잘한 부분도 , 부족한 부분도 온전히 나로 인한 결과라는 생각에 
하나의 기능을 구현하는데 있어서도 내가 고려하지 못한 변수는 없는지 , 더 좋은 구조로 재 사용하도록 설계할 수 없는지 스스로의 코드를 항상 의심하고 다시 확인하는 작업의 연속이였습니다 

이 프로젝트로 덕분에 많은 개발 능력이 향상되고 그중에서도 제가 가장 많은 부분 시간을 할애하고 성장했던 부분은 6가지 인것 같습니다 


- **api 목적성에 따른 실행흐름의 제어**</br>
- **재사용성**</br>
- **인터페이스 기반 프로그래밍**</br>
- **배포의 자동화**</br>
- **보안**</br>
- **체계적인 작업과 스스로 묻고 답하기**</br>

-------------------------------------------


### <a name="api-목적성에-따른-실행흐름-제어"></a> 📈 api 목적성에 따른 실행흐름 제어

case 1) **schedule 을 활용한 비동기적 api 호출 상태 확인**</br>
실물영수증을 사진으로 받아 데이터화 하는데는 마이크로소프트의 azure 서비스를 외부 api 로 사용하였습니다 </br>
이 과정에서 외부api을 호출을 바로 응답을 받으면 성공여부는 success이지만 , 안에 데이터는 아직 파싱중이라는 메세지를 받고 ,</br>
**호출 후 3초에서 4초후에 완전한 응답을 받을 수 있었습니다 
실행흐름을 제어하지 않으면 , 클라이언트단으로 빈 데이터를 보내는 일이 발생하였습니다 **

이에 자바의 schedule 을 활용하여 호출을 하고 5초동안 비동기적으로 API 호출의 상태를 주기적으로 확인할 수 있도록 대응하였습니다

case 2) **api 목적성에 따라 반환시점 비동기를 이용한 이분기화**
저희 프로그램의 영수증 입력 api 는 실물 영수증을 서버에 전달하고 서버에서 정제된 영수증 데이터로 최적화를 진행하는 과정입니다 </br> 유저에게 최소화된 송금데이터를 제공할 수 있도록 데이터를 쌓는 역활입니다
api의 궁극적인 목적은 영수증을 입력받아 알고리즘을 통해 "최적화"하는 것이지만 , **유저의 입장에서는 자신이 하는 행위인 "영수증 등록"이 영수증 등록만 데이터 베이스에 잘 입력된다면 
추후의 최적화 과정에서의 오류나 , exception 에 대해 서버에서 클라이언트로 반환받는 것은 적절하지 않다고 생각하였습니다**
 
 영수증 입력 api 자체는
| 단계 | 설명 |
|------|------|
| a    | 영수증의 각 금액을 채무로 할당 |
| b    | 그룹 내 두 명의 유저 사이에 형성될 수 있는 관계를 노드화하여, 둘 사이의 거래를 하나로 통합하는 1차 최적화 |
| c    | 그룹 내 각 개인이 받거나 주어야 할 총액의 순액 구하기 |
| d    | DFS를 통해 앞뒤 가중치가 같은 에지를 하나로 생성하는 2차 최적화 |
| e    | 양방향 에지가 생성될 경우, 하나의 에지로 통일하는 3차 최적화 |

총 과정중 a 만 성공을 하면 클라이언트 단으로 바로 성공 메세지를 보내도록 설계하였고 성공메세지 인스턴스를 생성할 때 이벤트를 발행하여 리스너가  추후의 과정들 호출할 수 있도록 하였습니다</br>
또한 b~ e 의 과정 중 에러는 sentry 라는 외부 api 를 통해 서버측에 에러나 exception 이 발생하면 정해진 서버의 알림창인 이메일과 디스코드로 상세한 메세지를 받도록 설계하였습니다 </br>

앞서 최적화를 설명 드린 것처럼 3차 최적화는 2차 최적화가 일어나지 않는다면 (채무금액이 같은 노드가 연속된것이 없다면) </br>
양방향으로 에지가 형성될 가능성이 없기 때문에 3차 최적화는 2차 최적화가 진행된다는 전제하에 호출이 될 수 있도록 흐름을 제어 했습니다 

프로젝트를 진행하면서 동기적 프로그래밍이 클라이언트부터 데이터 베이스 저장까지의 기능을 수행함에 있어서 동작 순서 보장의 한계가있다는 것을 깨달았습니다 

저는 이에 이벤트기반 프로그래밍으로 제가 원하는 시점에 함수를 호출할 수 있도록 개선하였습니다 


-----------------------------------------

### <a name="재사용성"></a> 🔄 재사용성
  
 dto 를 설계 함에 있어서 포괄적으로 사용할 수 있는 dto를 작성하고 , 각 **상황에 맞게 @jsonInclude를 통해 데이터가 포함되어 있지 않다면 클라이언트 에게 보여지는 데이터를 구분하였습니다** 
 무엇보다 재사용성에 대해 가장 신경을 많이 쓴 부분은 errorHandler , exception 부분이였습니다 
 
 - **ErrorCode** </br>
 열거형을 통해서 표준화된 에러 코드를 사용할 수 있도록 하였으며 유지 보수가 용이하도록 새로 추가되는 에러 코드를 쉽게 확장할 수 있도록 설계하였습니다</br>
 - **Custom Exception** </br>
 특정 에러코드를 기반으로 예외를 이르키며 해당 코드의 의미와 함께 상세 메세지를 함께 제공할 수 있도록 설계하였습니다 </br>
 - **Http status code mapping** </br>
 각 에러 코드에 적절한 Http 상태 코드를 매핑하여 클라이언트가 api 응답을 통해 명확한 상태를 파악할 수 있도록 하였습니다</br>
 - **Global Error handler** </br>
 각 예외 대해 일관된 응답을 생성하고 CustomException, SSLException 등 예외별로 다른 로직을 적용합니다</br>
 - **응답 포맷 통일** </br>
 응답마다 매번 다른 dto를 생성하는것은 인스턴스의 낭비라고 생각하고 처음 기획할 때 부터 응답은 아래와 같은 형식의 객체로 통일하여 클라이언트에게 응답에대한 혼란을 줄이고자 했습니다 

<img width="759" alt="스크린샷 2024-05-13 오후 3 43 54" src="https://github.com/Settle-Up/settle-up-server/assets/129722492/c997ae9e-ad47-46e8-ac47-93b70effbaa7">

 -----------------------------------
 
### <a name="인터페이스-기반-프로그래밍"></a> 🔌 인터페이스 기반 프로그래밍
  
저희 프로그램은 유저의 비용 내역이 1차 , 2차 , 3차 최적화를 통해 이루어집니다 각각의 최적화이름은 OptimizedTransaction , GroupOptimizedTransaction , UltimateTransaction 입니다
여기서는 편의상 1차 2차 3차라고 쓰겠습니다  

1차의 경우에는 requireTransaction 을 통해 도출이 됩니다  </br>
, 2차 최적화는 1차 최적화에 따라 </br>
, 3차 최적화는 1, 2차 최적화에 따라 발생합니다 </br>
기본적으로 3차 최적화를 먼저 탐색을 하고 , 3차를 생성한 2차 , 1차 최적화를 제외하고 
2차 최적화를 할때는 2차 최적화를 생성한 1차 최적화를 제외하고 
남은 최적화 리스트를 추합하였습니다 

위와 같이 방식으로 코드를 작성하다보니 많은 부분 코드가 중복 되었습니다 
이에 좀더 효율적인 방식을 사용하고자 1차, 2차 , 3차 를 구성하는 테이블의 형식을 동일 하게 하여 **하나의 인터페이스를 주입받도록** 하였고, 
그 인터페이스로 공통된 함수들을 정의하여 코드의 가독성을 높이고 중복을 줄였습니다 

  --------------------------------------------------

### <a name="배포의-자동화"></a> 🚀 배포의 자동화
   
   githubAction 과 AWS의 기능 중 하나인  EC2, S3 , Codedeploy 를 통해 지속적 통합 배포를 실현했습니다 
   제가 선택한 자동배포 전략은 아래의 플로우와 같습니다 
   
   ![스크린샷 2024-05-19 오후 7 27 10](https://github.com/Settle-Up/settle-up-server/assets/129722492/78edc2bf-10f0-4924-916b-4718bedb7d90)

   - 트리거 설정
   - 빌드 환경설정
   - 배포준비
   - AWS S3에 업로드
   - CodeDeploy를 통해 EC2 인스턴스에 배포
   - EC2 인스턴스 작업
   - 배포 로그 관리
     
   위의 과정을 이행하면서 가장 많은 시간을 할애 했던 것은 리눅스기반의 shell을 작성하여 배포과정을 자동화 하는 것과 배포의 자동화 플로우를 이해하는 것이였습니다.
   아래는 제가 두가지 문제 해결을 하면서 배포과정에서 이룬 주요 성과입니다

   - 자동화를 위한 shell 스크립트 작성
     배포 프로세스의 여러 단계를 자동화하기 위해 견고한 셸 스크립트 개발.
     환경 설정, 빌드, 배포 및 배포 후 작업을 위한 스크립트 작성으로 셸 스크립트 작성 능력 향상.
     스크립트 내 오류 처리 및 알림 자동화하여 원활한 CI/CD 파이프라인 구현.

  - 배포 자동화 흐름 이해 및 구현
    CI/CD 파이프라인 및 배포 자동화 원칙에 대한 깊은 이해를 얻음.
    GitHub Actions와 AWS 서비스를 성공적으로 통합하여 코드 변경에서 배포까지 원활하게 전환.
    배포의 각 단계를 명확하게 이해하고 실행하여 안정적이고 신뢰할 수 있는 자동 배포 시스템 구축.

    이 프로젝트를 통해 Shell 스크립트 작성 및 배포 자동화에 대한 깊은 이해를 바탕으로, 효율적이고 신뢰성 높은 배포 프로세스를 구현하는 데 기여했습니다. 이 경험을 통해 문제 해결 능력과 DevOps 역량을 크게 향상시켰습니다.

   --------------------------------

### <a name="보안"></a>🔒 보안
보안 문제는 프로젝트를 진행하면서 다방면에서 고려되었습니다. 대부분의 프로젝트에서 일반적으로 다루는 부분을 제외하고, 저희 프로젝트에서 특히 고심했던 4가지 문제를 열거하고자 합니다:

	1. 데이터베이스 스키마 PK 값 노출 문제
	2. 로그아웃 유저의 관리 (블랙리스트 관리 도입)
	3. 자동 배포의 보안 문제
	4. 토큰에 담기는 클레임 노출 문제
      
**1.데이터 베이스의 스키마 PK 값 노출**
   
**문제점**:</br>
백엔드와 프론트엔드가 소통하는 데 있어서 고유한 식별자를 통해 소통해야 합니다.</br>
하지만 기본 키(PK)를 노출하는 것은 악의적인 사용자나 공격자로부터 악용될 수 있는 보안상의 문제가 될 수 있다고 생각했습니다. 구글링을 통해 PK 값이 노출되면 다음과 같은 보안상의 문제가 발생할 수 있다는 것을 알았습니다:

- 데이터베이스의 구조와 레코드 수에 대한 정보를 유추할 수 있음
- IDOR(Insecure Direct Object References) 공격에 취약할 수 있음
- 연결된 데이터에 대한 공격 가능성</br>
   

**문제 해결 및 성장 포인트**:</br>
기본 키(PK) 대신 예측이 불가능한 랜덤 UUID를 사용하여 보안을 강화했습니다. </br>
이를 통해 랜덤 UUID 생성 및 활용 방법을 학습하고, 데이터베이스 설계 시 보안성을 높이는 방법을 익히게 되었습니다. 랜덤 UUID를 통해 예측 가능성을 줄이고, IDOR 공격을 방지하는 등 실질적인 보안 강화 방법을 구현할 수 있었습니다.
   
   **2.로그아웃 유저의 관리**
    
**문제점**:</br>
로그아웃을 도입하면서 여러 블로그 글을 참고해보니, 백엔드 서버에서만 로그아웃을 처리하거나 프론트엔드에서만 쿠키나 세션에서 토큰을 삭제하는 방법, </br>
또는 둘 다 사용하는 방법이 있었습니다. 가장 안전하고 효율적인 방법을 선택하기 위해 각각의 차이점과 문제점을 분석했습니다.

   c1) 프론트엔드에서만 쿠키 또는 세션에서 토큰을 삭제하는 방법:

	- 서버의 저장된 토큰의 유효성을 무효화할 수 없음
	- 악의적인 사용자가 로그아웃된 토큰을 복사하여 사용할 가능성
	- 중간자 공격 및 세션 하이재킹 위험 
  
   c2) 서버에서만 블랙리스트로 토큰을 관리하고 프론트엔드에서는 별다른 조치를 취하지 않는 방법:

	- 사용자의 혼란 유발
	- 세션 하이재킹 문제 및 쿠키 도용 가능성

**문제 해결 및 성장 포인트**:</br>
백엔드에서 Redis의 블랙리스트를 활용하고, 로그아웃 시 프론트엔드에서도 토큰을 즉시 삭제하는 방법을 도입했습니다. </br>
 **JwtVerificationFilter** 를 통하여 중앙 집중식 토큰 관리를 하여 토큰의 유효성을 일관성 있게 유지하고, 레디스를 이용한 블랙리스트에 추가된 토큰은 재사용할 수 없도록 하여 replay 공격을 방지했습니다.</br>
이를 통해 서비스의 보안 수준을 향상시켰습니다.
   
   **3.자동 배포의 보안 문제**
   
**문제점**:</br>
처음 작성해보는 Shell 스크립트로 민감한 정보(.env)가 GitHub에 업로드되지 않고 인스턴스 안에서 주입받아야 하는 부분이 난제였습니다.</br>

**문제해결 및 성장포인트**:</br> 
저는 이에 githubAction의 Secert을 활용하였고 , application.yml 같은 민감한 정보를 담은 파일은 인스턴스에서 파일을 실행할때 인스턴스 안에서 생성을 하고 , 성공적으로 실행된것이 확인이 되면 </br>
인스턴스안에 남아있는 민감정보를 자동으로 지워주는 일련의 과정을 shell로 작성하였습니다 </br>

배포과정을 설계하고 , 코드를 작성하면서 많은 블로그를 찾아보았는데 여러 블로그에서 인스턴스 자체에서 환경변수(export) 를 해서 민감정보를 그대로 노출하는 방식을 사용하여 진행한것을 볼수 있었습니다 </br>
저는 환경변수를 그대로 노출하는 경우는 시스템의 다른 사용자가 환경변수를 통해 쉽게 접근할 수 있고 , 환경변수에 저장된 민감정보가 로그에 기록될수 있어서 상당히 보안적으로 위험하다고 생각했습니다 </br>
   
배포의 자동화를 도입하기 전에는 생각해보지 못했던 여러 보안적 측면에서 고려할 수 있었습니다
   
   **4.토큰에 담기는 클레임 노출 문제**
   
**문제점**:</br>
JWT를 통해 토큰을 생성하면서 사용자 식별 정보를 토큰의 클레임에 담았습니다. </br>
그러나 JWT는 Base64 URL 인코딩을 사용하기 때문에 누구나 쉽게 디코딩할 수 있어 사용자 이름과 UUID와 같은 민감한 정보가 노출될 수 있다는 점이 염려되었습니다.</br>
비록 노출되는 값이 PK가 아니고 랜덤 UUID일지라도, 디코딩된 정보로 인해 사용자 데이터가 도용될 수 있음을 우려했습니다.</br>

**문제 해결 및 성장 포인트**:</br>
AES Encryption 알고리즘을 이용하여 서버에서 클레임을 한 번 더 암호화했습니다.</br>
UserUUID와 userName 키 값을 암호화하여 서버와 프론트엔드에서만 알 수 있도록 했습니다. </br>
이를 통해 중간 탈취자가 유저를 특정할 수 없고, 디코딩된 정보로 인해 사용자 데이터를 분석할 기회를 최소화했습니다.</br>
   
     문제해결 전:  
![스크린샷 2024-05-20 오전 9 45 13](https://github.com/Settle-Up/settle-up-server/assets/129722492/d2d4f813-91af-44dc-b348-645799fb0057)

	문제해결 후 :
![스크린샷 2024-05-20 오전 9 45 21](https://github.com/Settle-Up/settle-up-server/assets/129722492/5deb85ff-296f-4735-b924-cee31e75d34a)


   
### <a name="체계적인-작업과-스스로-묻고-답하기"></a>🧠 체계적인 작업과 스스로 묻고 답하기

  백엔드 서버 , 프론트엔드 각 한명씩 진행하다보니 처음에는 걱정되는 부분이 크게 3가지가 있었습니다 
  
- **한 명이 프로젝트에서 이탈할 경우, 프로젝트 진행이 지연되거나 어려워질 수 있다.** </br>
- **개인이 서버를 개발하는 경우, 조직 규칙보다 개인적인 선호도에 따라 개발될 위험이 있다.** </br>
- **문제 해결 방안은 팀원과 공유할 수 있지만, 최종적으로 해결하고 이행하는 것은 나의 몫이다.** </br>

  이 3가지를 해결하기 위해 아래와 같은 방식으로 진행하였습니다 

  
  1.한 명이 프로젝트에서 이탈할 경우, 프로젝트 진행이 지연되거나 어려워질 수 있다 <br>
  
	프로젝트 기획 및 초기 개발 단계에서는 의논할 사항이 많을 것이라 예상하여 매일 오프라인 미팅을 진행했습니다. </br>
 	프로젝트의 청사진이 어느 정도 잡힌 후에는 각자 작업하기 좋은 환경에서 오전 11시와 오후 9시에 온라인 미팅을 통해 진행 상황을 공유했습니다.</br>
	팀원과 개발 분야는 서로 다르지만 매일 오늘의 컨디션이 어떤지, 블로커 상황에서 어떤 방법을 도입했는지에 대해 공유하고 프로젝트가 끝날때 까지 호흡을 맞출 수 있었습니다</br>
  
  2.개인이 서버를 개발하는 경우, 조직 규칙보다 개인적인 선호도에 따라 개발될 위험이 있다.</br>
     
	프로젝트 기획이 끝난 후 노션을 통해 공용 페이지를 만들고,</br>
	프론트엔드와 백엔드에서 공유할 사항(와이어프레임, ERD, API 명세)을 분리하여 관리했습니다. API를 기반으로 우선순위를 정하고, 각 API에 필요한 기간을 나누어 작업했습니다.</br>

	또한, DDD와 MVC 모델을 활용하여 일관된 아키텍처를 설계했습니다.</br>
	 MVC 계층 구조로 도메인, 서비스, 프레젠테이션 계층 간 의존성을 통제했고, DDD 모델로 일관된 구조를 유지했습니다.</br>
 	 깃허브 브랜치 전략은 main(배포), develop(개발), hotfix(긴급 수정), feature(기능)로 구분해 혼자 서버를 개발하면서도 팀 작업처럼 일관성을 유지했습니다.</br>

 3.문제 해결 방안은 팀원과 공유할 수 있지만, 최종적으로 해결하고 이행하는 것은 나의 몫이다</br>

  프로젝트를 진행하면서 가장 힘들었던것은 FE , BE 각 한명씩 프로젝트를 진행하다보니 각 파트에 대한 모르는 부분이나 명확하지 않은 부분을 전부 혼자 해결해야하는 것이였습니다 </br>
  항상코드를 작성하면서 "이 방법이 최선인가?"에 대해 많이 고민하고 다른 사람들은 어떤 식으로 하는지 찾아봤던것 같습니다 

  api를 작성하면서 해당 기능에대해 너무 방대하고 막막하게 느껴질때면 api 를 작성하기 전에 javadoc 을 이용해서 
```
/**
해야하는기능:
받는데이터:
반환해야할 값:
기능세분화 1.:
기능세분화 2. :
/**
```
위와 같이 적어 두고 스스로에게 묻고 답을 찾아가는 방식으로 진행하였습니다 </br>
본프로젝트를 진행하면서 전반적인 부분을 모두 담당개발을 진행한 결과 전반적인 백엔드 서버에 대해 이해도가 깊어지고 개발하는 방식에대한 체계성이 생겼습니다

---------------------------------------------------------------
##  <a name="시연영상"></a> 💡시연영상



-------------------------------------------------------------------------      
##  <a name="협업툴"></a>🤝협업툴

<div>
<img src="https://img.shields.io/badge/Discode-4A154B?style=flat&logo=Slack&logoColor=white"/>
<img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=Notion&logoColor=white"/>
</div>
