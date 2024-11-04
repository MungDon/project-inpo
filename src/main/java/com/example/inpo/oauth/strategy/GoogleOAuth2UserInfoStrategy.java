package com.example.inpo.oauth.strategy;

import com.example.inpo.oauth.user.GoogleOAuth2UserInfo;
import com.example.inpo.oauth.user.OAuth2UserInfo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("google")
public class GoogleOAuth2UserInfoStrategy implements OAuth2UserInfoStrategy{

    @Override
    public OAuth2UserInfo getOAuth2UserInfo(String accessToken, Map<String, Object> attributes) {
        return new GoogleOAuth2UserInfo(accessToken,attributes);
    }
}
