package com.strafeup.cashiersystemspring.service.impl;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.Role;
import com.strafeup.cashiersystemspring.entity.UserEntity;
import com.strafeup.cashiersystemspring.repository.UserRepository;
import com.strafeup.cashiersystemspring.service.AuthService;
import com.strafeup.cashiersystemspring.service.exception.EntityAlreadyExistsException;
import com.strafeup.cashiersystemspring.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity login(@NotNull String email, @NotNull String password) {
        return userRepository.findByEmail(email)
                .filter(x -> passwordEncoder.matches(password, x.getPassword()))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void register(@NotNull User user) {
        Optional<UserEntity> userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb.isPresent()) {
            throw new EntityAlreadyExistsException();
        } else {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(user.getEmail());
            newUser.setPassword(passwordEncoder.encode(user.getPassword1()));
            newUser.setUsername(user.getUsername());
            newUser.setRole(Role.DEFAULT);
            System.out.println(user);
            System.out.println(newUser);
            userRepository.save(newUser);
        }
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
