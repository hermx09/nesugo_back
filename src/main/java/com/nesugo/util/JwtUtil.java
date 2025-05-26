package com.nesugo.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final SecretKey key;// 本番では環境変数にする
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; // 24時間

    public JwtUtil() {
        // 32バイト以上の秘密鍵を使用（本番では環境変数などで管理）
        String secret = "Suisui1211-some-long-secret-key-xyz!@#";
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String userName, int userId) {
        return Jwts.builder()
                .setSubject(userName)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
