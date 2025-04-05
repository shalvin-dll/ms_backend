package com.shalvin.messenger.service.impl;

import com.shalvin.messenger.dao.UserDao;
import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.model.UserDTO;
import com.shalvin.messenger.request.LoginRequest;
import com.shalvin.messenger.response.BaseResponse;
import com.shalvin.messenger.service.UserService;
import com.shalvin.messenger.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUser(User user) {
        return userDao.save(user);
    }

    public User updateUser(User user) {
        Optional<User> existingUser = userDao.findById(user.getId());
        if (existingUser.isPresent()) {
            return userDao.update(user);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }

    public boolean deleteUser(Long id) {
        return userDao.delete(id);
    }

    public UserDTO getUserById(Long id) {
        Optional<User> userOpt = userDao.findById(id);
        return userOpt
                .map(user -> ObjectMapperUtil.objectMapper.convertValue(user, UserDTO.class))
                .orElse(null);
    }

    public boolean userExists(Long id) {
        return userDao.findById(id).isPresent();
    }

    public BaseResponse<?> login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        Optional<User> userOpt = userDao.findByUsernameOrEmail(username, username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (password.equals(user.getPassword())) {
                UserDTO userDTO = user.toDTO();
                return new BaseResponse<>(true, userDTO);
            } else {
                return new BaseResponse<>(false, "Invalid credentials");
            }
        } else {
            return new BaseResponse<>(false, "User not found");
        }
    }
}

