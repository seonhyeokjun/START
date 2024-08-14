package com.toyproject.seonbae.user.domain.repository;

import com.toyproject.seonbae.user.domain.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByRegId(Long regId);
}
