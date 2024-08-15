package com.start.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    LOGIN_FAILED(401, "USER-001", "로그인 실패")
    ;

    private final int status;
    private final String code;
    private final String description;
}
