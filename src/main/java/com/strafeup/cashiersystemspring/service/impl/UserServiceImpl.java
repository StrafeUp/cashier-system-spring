package com.strafeup.cashiersystemspring.service.impl;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Page<User> findAll(int parsePageNumber) {
        return null;
    }
}
