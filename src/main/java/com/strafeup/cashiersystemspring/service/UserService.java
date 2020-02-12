package com.strafeup.cashiersystemspring.service;

import com.strafeup.cashiersystemspring.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> findAll(int parsePageNumber);
}
