# [Winner One](https://winnerone.site/)

### 해당 웹 페이지는 모바일 크기를 기준으로 만들었습니다. 
#### (Moblie M - 375px)

## 📍 소개

***
**프로젝트 내용**: 패키지 여행 서비스

**프로젝트 배경**: 개인 여행 일정 잡는 것을 어려워 하는 세대에게 적합한 패키지 여행 중심의 서비스 기획

**프로젝트 기간**: 2023년 12월 04일 ~ 2024년 01월 29일

**서비스**: https://winnerone.site


### 기술 스택

- **언어**: Java 17
- **개발 환경**: IntelliJ, Gradle, Spring Boot 3
- **라이브러리**: Spring Web, Spring Security, JPA, QueryDSL, Lombok, JWT, OAuth2
- **배포**: EC2, RDS(MySQL)
- **CI**: GitHub Actions
- **API 명세** : Notion

### API 명세
![image](https://github.com/yanolja-finalproject/Backend/assets/87019291/71805583-c1e2-4883-b761-473672e91455)
![image](https://github.com/yanolja-finalproject/Backend/assets/87019291/139938cb-d313-415e-b3f1-0aab5950857f)

https://www.notion.so/API-8f9afb2bae01438ba77c63092f2a4dd1

### 서버 구조도
![image](https://github.com/yanolja-finalproject/Backend/assets/87019291/5f617311-8d6d-43c5-b292-0fe59177deee)


## ⚖️ [컨벤션]

----

### 1. 코딩 컨벤션

- [IntelliJ Java Google Style](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml)을 준수합니다.
    
    [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
    
### 2. 패키지 구조도

```bash
com.yanolja_fianl
├── domain
│   ├── user
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── exception
│   │   ├── facade
│   │   ├── repository
│   │   └── service
│   ├── travel
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── exception
│   │   ├── facade
│   │   ├── repository
│   │   └── service
│   ...
└── global
    ├── auth
    ├── common
    ├── config
    ├── error
    ├── infra
    └── util
```

### 3. 기타 합의사항

- **협업 관련**
    - 데일리 스크럼: 매일 오후 18:00 팀 전체 데일리 스크럼 진행
      <br><br>
- **커밋 메시지 관련**
    - 커밋 제목은 `prefix: 커밋 메시지` 형태로 합니다.
    - prefix의 목록과 각각의 용도는 IntelliJ 플러그인에서 볼 수 있습니다.
    - IntelliJ 플러그인 적용법: https://blog.naver.com/rinjyu/222157082860
    - 커밋 내용을 자세하게 적습니다. (커밋 제목과 내용만 보더라도 코드 내용이 파악 가능할 정도로)

## 🗺️ 기획안

---

## ERD
![Winnerone](https://github.com/yanolja-finalproject/Backend/assets/87019291/94fa3373-0bda-420a-b896-f055d07b5fea)

## 사진
![image](https://github.com/yanolja-finalproject/Backend/assets/87019291/51b20a20-5cdc-49ba-87c7-571c363c97a9)

![image](https://github.com/yanolja-finalproject/Backend/assets/87019291/092e3f1b-5427-4790-8845-74927c5991ce)
![image](https://github.com/yanolja-finalproject/Backend/assets/87019291/8d2b94ca-97a5-4f67-9e06-92eadf6a93c5)
