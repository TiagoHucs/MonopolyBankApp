package com.monopolybankapp.security;

public class UserContext {
    private static final ThreadLocal<String> userContext = new ThreadLocal<>();

    public static String getUserInfo() {
        return userContext.get();
    }

    public static void setUserInfo(String userInfo) {
        userContext.set(userInfo);
    }

    public static void clear() {
        userContext.remove();
    }
}