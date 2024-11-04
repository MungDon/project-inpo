package com.example.inpo.oauth.user;

import java.util.Map;

public interface OAuth2UserInfo {

    String getAccessToken();

    Map<String, Object> getAttributes();

    String getId();

    String getEmail();

    String getName();
}
