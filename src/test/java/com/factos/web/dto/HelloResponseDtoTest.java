package com.factos.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertThat
        //assertj라는 테스트 검증 라이브러리의 검증 메서드
        //검증하고 싶은 대상을 메서드 인자로 받는다.
        //메서드 체이닝이 지원되어 isEqualTo와 같이 메서드를 이어 사용가능
        //isEqualTo
        //assertj의 동등 비교메서드, assertThat에 있는 값과 isEqualTo 값을 비교하여 같을 때만 성공

        //assertj가 junit보다 좋은점
        //자동완성이 확실히 지원됌, 추가적인 라이브러리가 필요하지않음 == is()와 같은 CoreMatches 라이브러리

    }
}
