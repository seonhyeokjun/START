package com.toyproject.seonbae.user.domain.service;

import com.toyproject.seonbae.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final TokenProvider tokenProvider;
}
