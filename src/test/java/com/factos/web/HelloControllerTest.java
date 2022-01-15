package com.factos.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
                // Param이란
                // API테스트할 때 사용된 요청 파라미터 설정
                // 값은 String만 허용
                // 그래서 숫자 혹은 날짜 등의 데이터는 형변환이 필요함
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        //jsonPath란
        //JSON 응답값을 필드별로 검증할 수 있는 메소드
        //$을 기준으로 필드명 명시
        //지금 name과 amount를 검증하니 $.name 등의 표기로 검증
    }
}
