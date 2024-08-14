package com.toyproject.seonbae.user.domain.service;

import com.toyproject.seonbae.exception.PasswordException;
import com.toyproject.seonbae.exception.UserNotFoundException;
import com.toyproject.seonbae.jwt.JwtFilter;
import com.toyproject.seonbae.jwt.TokenProvider;
import com.toyproject.seonbae.user.domain.dto.LoginRequestDto;
import com.toyproject.seonbae.user.domain.dto.TokenDto;
import com.toyproject.seonbae.user.domain.model.Token;
import com.toyproject.seonbae.user.domain.model.User;
import com.toyproject.seonbae.user.domain.repository.TokenRepository;
import com.toyproject.seonbae.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    /**
     * 로그인
     * @return
     */
    @Transactional
    public TokenDto login(LoginRequestDto loginRequestDto) throws UserNotFoundException, PasswordException {
        // jwt 생성
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserId(), loginRequestDto.getPassword());

        // UserDetailsService 호출하게 되고 그 호출되는 UserDetailsService 에서 생성된 user 정보와
        // authenticationToken의 정보를 비교하여 인증을 마친다. (비밀번호 검증도 함계 진행된다.)
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findOneWithAuthoritiesByUserName(loginRequestDto.getUserName()).orElseThrow(() -> new UserNotFoundException("가입되지 않은 ID 입니다."));

        if (passwordEncoder.matches(user.getPassword(), loginRequestDto.getPassword())) {
            throw new PasswordException("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = tokenProvider.createAccessToken(user);
        String refreshToken = tokenProvider.createRefreshToken(user);

        // 기존의 refresh token이 존재한다면 삭제
        tokenRepository.findByRegId(user.getUserId()).ifPresent(tokenRepository::delete);
        // 새로운 refresh token 저장
        tokenRepository.save(Token.builder().token(refreshToken).build());

        ResponseCookie accessTokenCookie = ResponseCookie.from(JwtFilter.AUTHORIZATION_HEADER, accessToken)
                .httpOnly(true)
                .path("/")
                .maxAge(Duration.ofDays(1))
                .build();

        ResponseCookie refreshTokenCookie = ResponseCookie.from(JwtFilter.REFRESH_TOKEN_HEADER, refreshToken)
                .httpOnly(true)
                .path("/")
                .maxAge(Duration.ofDays(7))
                .build();

        return TokenDto.builder().accessToken(accessTokenCookie.toString()).refreshToken(refreshTokenCookie.toString()).build();
    }

    @Transactional
    public void signup() {

    }
}
