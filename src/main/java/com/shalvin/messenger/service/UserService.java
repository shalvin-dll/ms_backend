package com.shalvin.messenger.service;

import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.model.UserDTO;
import com.shalvin.messenger.request.LoginRequest;
import com.shalvin.messenger.response.BaseResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    boolean deleteUser(Long id);
    UserDTO getUserById(Long id);
    boolean userExists(Long id);
    BaseResponse<?> login(LoginRequest request);
}

