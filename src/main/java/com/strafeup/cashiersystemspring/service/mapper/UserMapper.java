package com.strafeup.cashiersystemspring.service.mapper;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserEntity, User> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity mapDomainToEntity(User domain) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(domain.getId());
        userEntity.setUsername(domain.getUsername());
        userEntity.setEmail(domain.getEmail());
        userEntity.setPassword(passwordEncoder.encode(domain.getPassword1()));
        userEntity.setRole(domain.getRole());

        return userEntity;
    }

    @Override
    public User mapEntityToDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(entity.getRole())
                .password1(entity.getPassword())
                .build();
    }
}
