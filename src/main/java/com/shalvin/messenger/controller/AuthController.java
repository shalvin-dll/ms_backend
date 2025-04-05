package com.shalvin.messenger.controller;

import com.shalvin.messenger.request.LoginRequest;
import com.shalvin.messenger.response.BaseResponse;
import com.shalvin.messenger.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public BaseResponse<?> login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
