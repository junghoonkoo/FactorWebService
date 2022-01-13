package com.factos.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)  //SpringRunner는 실행자
// 스프링부트테스트와 JUnit사이의 연결자
// 테스트를 진행할 때에는 JUnit에 내장된 실행자가 아닌 다른 실행자를 실행시켜야한다,
@WebMvcTest(controllers = HelloController.class)
//스프링 테스트 어노테이션 중 web에 집중할 수 있음
//Controller, ControllerAdvice 사용가능 / Servic, Component 등 사용 불가능
public class HelloControllerTest {

    @Autowired
    //Bean 주입
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
