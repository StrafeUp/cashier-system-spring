package com.strafeup.cashiersystemspring.service.mapper;

import com.strafeup.cashiersystemspring.domain.User;
import com.strafeup.cashiersystemspring.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final String PASSWORD = "password";

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void mapUserToUserEntityShouldMapCorrectly() {
        User user = User.builder()
                .email("test@gmail.com")
                .username("Example")
                .password1(PASSWORD)
                .password2(PASSWORD)
                .build();
        when(passwordEncoder.encode(anyString())).thenReturn(ENCODED_PASSWORD);
        UserEntity userEntity = userMapper.mapDomainToEntity(user);

        assertEquals(ENCODED_PASSWORD, userEntity.getPassword());
    }

    @Test
    public void mapUserEntityToUserShouldMapCorrectly() {
        UserEntity exampleUser = new UserEntity();
        exampleUser.setId(1L);
        exampleUser.setEmail("test@gmail.com");
        exampleUser.setUsername("Example");
        exampleUser.setPassword(PASSWORD);
        User user = userMapper.mapEntityToDomain(exampleUser);
        assertEquals("test@gmail.com", user.getEmail());
    }
}