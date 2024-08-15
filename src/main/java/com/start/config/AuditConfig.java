package com.start.config;

import com.start.util.SecurityUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String userName = SecurityUtil.getCurrentUsername().orElseGet(null);
        return Optional.ofNullable(userName);
    }
}
