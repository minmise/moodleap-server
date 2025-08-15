package com.moodleap.server.controller;

import com.moodleap.server.dto.AuthRequest;
import com.moodleap.server.dto.AuthResponse;
import com.moodleap.server.model.User;
import com.moodleap.server.security.JwtUtil;
import com.moodleap.server.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        User user = authService.register(request.getEmail(), request.getPassword());
        String token = JwtUtil.generateToken(user.getUid());
        return new AuthResponse(user.getUid(), "Bearer " + token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = authService.login(request.getEmail(), request.getPassword());
        String token = JwtUtil.generateToken(user.getUid());
        return new AuthResponse(user.getUid(), "Bearer " + token);
    }

}
