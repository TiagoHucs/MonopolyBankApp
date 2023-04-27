package com.monopolybankapp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = Logger.getLogger(JwtInterceptor.class.getName());

    private final JwtUtils jwtUtils;

    @Autowired
    public JwtInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        LOGGER.log(Level.INFO,request.toString());
        if (header == null || !header.startsWith("Bearer ")) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            LOGGER.log(Level.INFO, "chamada sem token");
            return false;
        }

        final String token = header.substring(7);

        if (!jwtUtils.validateToken(token)) {
            LOGGER.log(Level.INFO, "token invalido");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        UserContext.setUserInfo(jwtUtils.getUsernameFromToken(token));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.clear();
    }
}
