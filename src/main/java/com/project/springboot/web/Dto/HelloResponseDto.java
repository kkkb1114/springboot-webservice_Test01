package com.project.springboot.web.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor // final이 없는 필드는 생성자에 포함 X
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
