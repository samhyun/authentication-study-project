package com.samhyun.auth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

public class TokenAuthenticationHelper {
    private static final long EXPIRATION_TIME = 1000 * 60 * 30; // 30 minutes
    private static final String SECRET = "ThisIsASecret";
    public static final String COOKIE_BEARER = "COOKIE-BEARER";

    private TokenAuthenticationHelper() {
        throw new IllegalStateException("Utility class");
    }

    static void addAuthentication(HttpServletResponse res, Authentication auth) {

        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String jwt = Jwts.builder()
                .setSubject(auth.getName())
                .claim("authorities", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        Cookie cookie = new Cookie(COOKIE_BEARER, jwt);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        res.addCookie(cookie);
    }

    static boolean validate(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }

    }

    static String getToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, COOKIE_BEARER);
        return cookie != null ? cookie.getValue() : null;
    }

    static Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

//            Collection<? extends GrantedAuthority> authorities =
//                    Arrays.stream(claims.get("authorities").toString().split(","))
//                            .map(SimpleGrantedAuthority::new)
//                            .collect(Collectors.toList());

        String userName = claims.getSubject();
        return userName != null ? new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>()) : null;
    }
}