package com.example.inpo.jwt;

import com.example.inpo.utils.CommonUtil;
import com.example.inpo.utils.CookieUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.example.inpo.utils.CookieUtil.ACCESS_TOKEN_COOKIE_NAME;
import static com.example.inpo.utils.CookieUtil.REFRESH_TOKEN_COOKIE_NAME;

@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("JWTFilter start, currentUri : {}", request.getRequestURI()); // 현재 요청 uri

        // 쿠키에서 각 토큰 값 디코딩 후 추출
        String accessToken = CookieUtil.getCookie(request, ACCESS_TOKEN_COOKIE_NAME).orElse(""); //accessToken
        String refreshToken = CookieUtil.getCookie(request, REFRESH_TOKEN_COOKIE_NAME).orElse("");


        // 리프레쉬 토큰 쿠키에서 가져온거 없으면 로그인 화면
        if(!jwtUtil.isValidToken(refreshToken)){
            response.sendRedirect("/home");
        }

        // 각 쿠키의 Bearer 공백뒤에 실제 토큰 값을 가져옴
        String accessValue = jwtUtil.isValidToken(accessToken) ? "" : accessToken.split(" ")[1] ;
        log.info("accessToken : {}",accessToken);

        String refreshValue  = refreshToken.split(" ")[1];
        log.info("refreshToken : {}",refreshToken);
        
        //TODO - JWTService 에서 refresh Token 이 Member 정보와 일치한지 검사하고 AccessToken 비었을경우 재생성
    }


}
