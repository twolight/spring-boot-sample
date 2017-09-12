package com.twolight.server.service;

import com.twolight.server.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private RedisService redisService;

    public Token createToken(long userId) {
        String authentication = UUID.randomUUID().toString().replace("-", "");
        redisService.saveAuthorization(userId, authentication);
        return new Token(userId, authentication);
    }

    public Token getToken(String token) throws Exception {
        if (token == null || token.length() == 0) {
            return null;
        }

        String[] param = token.split("\\.");
        if (param.length != 2) {
            return null;
        }

        try {
            long userId = Long.parseLong(param[0]);
            String authentication = param[1];
            return new Token(userId, authentication);
        } catch (Exception exception) {
            return null;
        }
    }

    public boolean checkToken(Token token) {
        if (token == null) {
            return false;
        }
        String authentication = redisService.getAuthorization(token.getUserId());
        if (authentication == null || !authentication.equals(token.getAuthentication())) {
            return false;
        }

        redisService.refreshAuthorizationExpired(token.getUserId());
        return true;
    }

    public void deleteToken(long userId) {
        redisService.deleteAuthorization(userId);
    }
}
