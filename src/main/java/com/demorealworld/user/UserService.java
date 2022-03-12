package com.demorealworld.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public RegisterForm saveNewUser(@Valid RegisterForm registerForm) {
        registerForm.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        User newUser = userRepository.save(modelMapper.map(registerForm, User.class));
        return modelMapper.map(newUser, RegisterForm.class);
    }
}
