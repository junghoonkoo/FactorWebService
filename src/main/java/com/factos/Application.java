package com.factos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//스프링부트의 자동설정, 스프링 Bean읽기와 생성 모두 자동설정
//@SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 프로젝트 최상단에 위치해야함

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    //SpringApplication.run == 내장 was 사용
    }
}
