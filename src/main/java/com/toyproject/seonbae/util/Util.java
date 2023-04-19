package com.toyproject.seonbae.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Util {
    public static long parseLong(String value) {
        if (value.isEmpty() || value == null) {
            return 0;
        } else  {
            return Long.parseLong(value);
        }
    }
}
