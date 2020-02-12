package com.strafeup.cashiersystemspring.service;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.UserEntity;

import java.util.Optional;

public interface AuthService {
    UserEntity login(String email, String password);

    void register(User user);

    Optional<UserEntity> findByEmail(String email);
}
