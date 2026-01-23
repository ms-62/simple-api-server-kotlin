plugins {
    kotlin("jvm") version "1.9.22" // 코틀린 버전
    application
}

repositories {
    mavenCentral() // 라이브러리를 받아올 저장소
}

dependencies {
    // Ktor 서버 핵심 라이브러리들
    implementation("io.ktor:ktor-server-core:2.3.7")
    implementation("io.ktor:ktor-server-netty:2.3.7")
    implementation("ch.qos.logback:logback-classic:1.4.14") // 로그 출력용
    implementation("com.microsoft.playwright:playwright:1.40.0")
    
}

application {
   // mainClass.set("AppKt") // 실행할 메인 파일 지정 (파일명이 app.kt이면 AppKt로 입력)
    mainClass.set("PlaywrightTestKt") 
}