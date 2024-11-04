package com.example.inpo.oauth.service;

import com.example.inpo.oauth.user.OAuth2UserInfo;
import com.example.inpo.oauth.strategy.OAuth2UserInfoStrategy;
import com.example.inpo.oauth.user.OAuth2UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final Map<String, OAuth2UserInfoStrategy> userInfoStrategy;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException{
        log.info("CustomOAuth2UserService.loadUser start");

        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        return processOAuth2User(oAuth2UserRequest,oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User){

        // 현재 OAuth2 요청의 인증 제공자 ID를 가져온다 (예: "google", "facebook")
        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
        log.info("제공자 ID : {}", registrationId);

        // OAuth2 인증 과정에서 발급받은 액세스 토큰을 문자열로 가져온다
        String OAuthAccessToken = oAuth2UserRequest.getAccessToken().getTokenValue();
        log.info("OAuth2 액세스 토큰 : {}", OAuthAccessToken);

        // 제공자 ID 에 따라 가져오는 UserInfo 가 달라짐 ( 전략 패턴 )
        OAuth2UserInfoStrategy strategy = userInfoStrategy.get(registrationId);

        OAuth2UserInfo oAuth2UserInfo = strategy.getOAuth2UserInfo(OAuthAccessToken,oAuth2User.getAttributes());

        return new OAuth2UserPrincipal(oAuth2UserInfo);
    }
}
