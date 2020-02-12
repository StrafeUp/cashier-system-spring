package com.strafeup.cashiersystemspring.repository;

import com.strafeup.cashiersystemspring.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    Page<UserEntity> findAll(Pageable pageable);

    Optional<UserEntity> findByEmail(String email);
}
