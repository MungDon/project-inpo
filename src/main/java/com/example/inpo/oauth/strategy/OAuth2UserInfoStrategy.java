package com.example.inpo.oauth.strategy;

import com.example.inpo.oauth.user.OAuth2UserInfo;

import java.util.Map;

public interface OAuth2UserInfoStrategy {
    OAuth2UserInfo getOAuth2UserInfo(String accessToken, Map<String, Object> attributes);
}
