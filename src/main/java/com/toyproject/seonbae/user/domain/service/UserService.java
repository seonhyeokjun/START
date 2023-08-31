package com.toyproject.seonbae.user.domain.service;

import com.toyproject.seonbae.jwt.JwtFilter;
import com.toyproject.seonbae.jwt.TokenProvider;
import com.toyproject.seonbae.user.domain.dto.LoginRequestDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserService {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * 로그인
     */
    @Transactional
    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        // jwt 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserId(), loginRequestDto.getPassword());

        // UserDetailsService 호출하게 되고 그 호출되는 UserDetailsService 에서 생성된 user 정보와
        // authenticationToken의 정보를 비교하여 인증을 마친다. (비밀번호 검증도 함계 진행된다.)
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        // 쿠키생성
        ResponseCookie cookie = ResponseCookie.from(JwtFilter.AUTHORIZATION_HEADER, jwt)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(Duration.ofDays(1))
                .build();

        response.addHeader("Set-Cookie", cookie.toString());
    }
    @Transactional
    public void signup() {

    }
}
