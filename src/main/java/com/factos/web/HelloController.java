package com.factos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌

public class HelloController {
    @GetMapping("/hello")
    //GET의 요청을 받을 수 있는 API를 만들어준다.
    //RequestMapping(method =RequestMethod.GET 와 같은 맥락
    // /hello 요청이 오면 hello 반환
    public String hello() {
        return "hello";
    }
}
