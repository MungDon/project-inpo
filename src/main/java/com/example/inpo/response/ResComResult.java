package com.example.inpo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResComResult {

    private boolean success;

    private int statusCode;

    private String message;

    private Object responseData;
}
