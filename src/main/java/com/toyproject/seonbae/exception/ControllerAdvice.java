package com.toyproject.seonbae.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    /**
     * 유저를 찾지 못함
     */
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<?> nullPointExceptionHandler(UserNotFoundException e) {
        ErrorCode errorCode = ErrorCode.LOGIN_FAILED;
        log.error("server error log : ", e);
        return ResponseEntity.status(HttpStatus.valueOf(errorCode.getStatus())).body(ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(e.getMessage())
                .build());
    }

    /**
     * 비밀번호 불일치
     */
    @ExceptionHandler(value = PasswordException.class)
    public ResponseEntity<?> passwordExceptionHandler(PasswordException e) {
        ErrorCode errorCode = ErrorCode.LOGIN_FAILED;
        log.error("server error log : ", e);
        return ResponseEntity.status(HttpStatus.valueOf(errorCode.getStatus())).body(ErrorResponse.builder()
                .code(errorCode.getCode())
                .message(e.getMessage())
                .build());
    }
}
