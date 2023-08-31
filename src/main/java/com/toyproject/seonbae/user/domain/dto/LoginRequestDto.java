package com.toyproject.seonbae.user.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    @NotBlank
    private String userId;

    @NotBlank
    private String password;
}
