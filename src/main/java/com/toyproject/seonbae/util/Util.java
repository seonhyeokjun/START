package com.toyproject.seonbae.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class Util {
    public static long parseLong(String value) {
        if (value.isEmpty()) {
            return 0;
        } else  {
            return Long.parseLong(value);
        }
    }
}
