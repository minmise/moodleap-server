package com.moodleap.server.dto;

public class AuthResponse {

    private String uid;
    private String token;

    public AuthResponse(String uid, String token) {
        this.uid = uid;
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }

}
