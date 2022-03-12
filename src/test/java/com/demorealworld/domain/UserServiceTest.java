package com.demorealworld.domain;

import com.demorealworld.user.RegisterForm;
import com.demorealworld.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @DisplayName("user 등록 - 회원가입")
    @Test
    @Rollback(value = false)
    void register_new_user() {
        // given
        RegisterForm regForm = new RegisterForm();
        regForm.setEmail("test@email.com");
        regForm.setPassword("12345678");

        // when
        RegisterForm registeredUser = userService.saveNewUser(regForm);

        // then
        assertEquals(registeredUser.getEmail(), regForm.getEmail());
    }
}