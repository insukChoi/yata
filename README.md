yata - 넌 그냥 와 내가 플랜 짤게
==========================

- http://localhost:8088 (server)
- http://localhost:3001 (front)

## Front Build Setup

``` bash
cd yata-client

# install dependencies
npm install

# serve with hot reload at localhost:3001
npm run dev

# build for production with minification
npm run build
```

## Server Build Setup

``` bash
cd yata-server
gradle clean test bootRun
```

## 라이브러리 및 오픈소스
- Kotlin
- SpringBoot2.3.1
- JPA
- Lombok
- Vue JS
- Mysql5.7
- Redis
- Spring Security


## Naming Strategy
### Sql
*Table*
- Upper case (ACCOUNT)
- Snake case (TRIP_HISTORY)

*Colume*
- Lower case (name)
- Snake case (phone_number)

## Design
[UI prototype](https://ovenapp.io/project/vFFGagJRoYYKO5LvQ92xoJNVsB7pb7SP#zVfq7)
DE Schema: Intellij - Persistence - entity - ER diagram

## How to set up git review tool (Gerrit)

- Using IDE built-in plugin system (suggested: you'll get notified when an update is available):
  - Preferences > Plugins > Browse repositories... > Search for "Gerrit" > Install Plugin

- Sign up : http://gerrithub.io/
- Create and enroll ssh-key in gerrit site (https://docs.openstack.org/contributors/ko_KR/common/setup-gerrit.html)
- Generate HTTP password and enroll in Intellij 
[gerrit site](https://review.gerrithub.io/admin/repos/insukChoi/yata)

## API Docs
http://localhost:8088/swagger-ui.html

## Contributor
kyuli.yeo, kuu2002, insukChoi

