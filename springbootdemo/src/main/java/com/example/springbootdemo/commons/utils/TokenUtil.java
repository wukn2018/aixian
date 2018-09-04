package com.example.springbootdemo.commons.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-06-08
 * Time: 5:50 PM
 *
 * @author: fanzhengchen
 */
public class TokenUtil {

    /**
     * 5000 天
     */
    private static final long EXPIRATION_TIME = 432_000_000_000L;

    /**
     * jwt secret
     */
    private static final String SECRET = "asdsamgdamdlgmslamdg";
    private static final String TOKEN_PREFIX = "Bearer";
    /**
     * 存放在http header的Authorization
     */
    private static final String HEADER_STRING = "Authorization";


    public static String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static String getUsername(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();
        return claims.getSubject();
    }

    public static String getToken(HttpServletRequest request) {
        return request.getHeader(HEADER_STRING);
    }

    public static String getUsername(HttpServletRequest request) {
        return getUsername(getToken(request));
    }
}
