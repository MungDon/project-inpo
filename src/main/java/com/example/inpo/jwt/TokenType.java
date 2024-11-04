package com.example.inpo.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TokenType {
    ACCESS_TOKEN("access"),
    REFRESH_TOKEN("refresh");

    private final String tokenType;
}
