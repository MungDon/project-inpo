package com.example.inpo.oauth.strategy;

import com.example.inpo.oauth.user.GitHubOAuth2UserInfo;
import com.example.inpo.oauth.user.OAuth2UserInfo;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component("github")
public class GitHubOAuth2UserInfoStrategy implements OAuth2UserInfoStrategy{
    @Override
    public OAuth2UserInfo getOAuth2UserInfo(String accessToken, Map<String, Object> attributes) {
        return new GitHubOAuth2UserInfo(accessToken,attributes);
    }
}
