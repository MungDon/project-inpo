package com.example.inpo.oauth.user;

import java.util.Map;

public class GitHubOAuth2UserInfo implements OAuth2UserInfo{

    private final Map<String, Object> attributes;
    private final String accessToken;
    private String id;
    private String name;
    private String email;


    public GitHubOAuth2UserInfo(String accessToken, Map<String, Object> attributes) {
        this.attributes = attributes;
        this.accessToken = accessToken;
        this.id = String.valueOf(attributes.get("id"));
        this.name = (String) attributes.get("name");
        this.email = (String) attributes.get("email");
    }
    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
