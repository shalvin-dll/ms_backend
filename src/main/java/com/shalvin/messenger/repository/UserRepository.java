package com.shalvin.messenger.repository;

import com.shalvin.messenger.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> {

    // Find user by username
    Mono<User> findByUsername(String username);

    // Find user by email
    Mono<User> findByEmail(String email);

    // Find user by phone number
    Mono<User> findByPhoneNumber(String phoneNumber);

    Mono<User> findUserByUsernameOrEmail(String username, String email);
}

