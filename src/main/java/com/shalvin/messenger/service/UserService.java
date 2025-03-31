package com.shalvin.messenger.service;

import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.model.UserDTO;
import com.shalvin.messenger.request.LoginRequest;
import com.shalvin.messenger.response.BaseResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    public Mono<User> createUser(User user);
    public Mono<User> updateUser(User user);
    public Mono<Boolean> deleteUser(Long id);
    public Mono<UserDTO> getUserById(Long id);
    public Mono<Boolean> userExists(Long id);
    public Mono<BaseResponse<?>> login(LoginRequest request);
}
