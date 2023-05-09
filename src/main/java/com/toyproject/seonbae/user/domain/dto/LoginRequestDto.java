package com.toyproject.seonbae.user.domain.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String userId;
    private String password;
}
