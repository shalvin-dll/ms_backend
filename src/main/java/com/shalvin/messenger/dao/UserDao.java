package com.shalvin.messenger.dao;

import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.repository.UserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserDao {
    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    public Mono<Boolean> delete(Long id) {
        return userRepository.findById(id)
                .flatMap(user -> userRepository.delete(user)
                        .then(Mono.just(true)))
                .switchIfEmpty(Mono.just(false));
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> findByUsernameOrEmail(String username, String email) {
        return userRepository.findUserByUsernameOrEmail(username, email);
    }
}