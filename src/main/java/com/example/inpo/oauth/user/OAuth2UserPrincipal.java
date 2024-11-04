package com.example.inpo.oauth.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class OAuth2UserPrincipal implements OAuth2User, UserDetails {

    private final OAuth2UserInfo userInfo;


    @Override
    public String getPassword() {
        return String.valueOf(UUID.randomUUID());
    }

    @Override
    public String getUsername() {
        return userInfo.getEmail();
    }

    public String getOauthID () {
        return userInfo.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return userInfo.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getName() {

        return userInfo.getName();
    }

    public OAuth2UserInfo userInfo() {
        return userInfo;
    }

}
