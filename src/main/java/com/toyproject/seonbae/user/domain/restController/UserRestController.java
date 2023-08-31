package com.toyproject.seonbae.user.domain.restController;

import com.toyproject.seonbae.user.domain.dto.LoginRequestDto;
import com.toyproject.seonbae.user.domain.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    /**
     * 로그인
     * @param loginRequestDto
     * @param response
     */
    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
    }

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public void signup() {
        userService.signup();
    }
}
