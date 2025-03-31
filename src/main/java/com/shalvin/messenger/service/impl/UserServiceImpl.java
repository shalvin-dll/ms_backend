package com.shalvin.messenger.service.impl;

import com.shalvin.messenger.dao.UserDao;
import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.model.UserDTO;
import com.shalvin.messenger.request.LoginRequest;
import com.shalvin.messenger.response.BaseResponse;
import com.shalvin.messenger.service.UserService;
import com.shalvin.messenger.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl  implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public Mono<User> createUser(User user) {
        return userDao.save(user);
    }

    public Mono<User> updateUser(User user) {
        return userDao.findById(user.getId())
                .flatMap(existingUser -> userDao.update(user))
                .switchIfEmpty(Mono.error(new RuntimeException("User not found with id: " + user.getId())));
    }

    public Mono<Boolean> deleteUser(Long id) {
        return userDao.delete(id);
    }

    public Mono<UserDTO> getUserById(Long id) {
        return userDao.findById(id)
                .map(user -> ObjectMapperUtil.objectMapper.convertValue(user, UserDTO.class));
    }

    public Mono<Boolean> userExists(Long id) {
        return userDao.findById(id)
                .map(user -> true)
                .defaultIfEmpty(false);
    }

    public Mono<BaseResponse<?>> login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        return userDao.findByUsernameOrEmail(username, username)
                .flatMap(user -> {
                    if (password.equals(user.getPassword())) {
                        UserDTO userDTO = ObjectMapperUtil.objectMapper.convertValue(user, UserDTO.class);
                        return Mono.just(new BaseResponse<>(true, userDTO));
                    } else {
                        return Mono.just(new BaseResponse<>(false, "Invalid credentials"));
                    }
                })
                .switchIfEmpty(Mono.just(new BaseResponse<>(false, "User not found")));
    }

}
