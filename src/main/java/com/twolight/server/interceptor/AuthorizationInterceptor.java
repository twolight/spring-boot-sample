package com.twolight.server.interceptor;

import com.twolight.server.Constants;
import com.twolight.server.common.exception.InvalidTokenException;
import com.twolight.server.entity.Token;
import com.twolight.server.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        String tokenText = request.getHeader(Constants.TOKEN);
        if (tokenText == null) {
            throw new InvalidTokenException();
        }

        Token token = tokenService.getToken(tokenText);
        if (!tokenService.checkToken(token)) {
            throw new InvalidTokenException();
        }

        request.setAttribute(Constants.CURRENT_USER_ID, token.getUserId());
        return true;
    }

}
