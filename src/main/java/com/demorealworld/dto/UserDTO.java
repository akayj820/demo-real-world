package com.demorealworld.dto;

import com.demorealworld.user.RegisterForm;
import lombok.Data;

import javax.validation.Valid;

@Data
public class UserDTO {

    @Valid
    private RegisterForm user;
}
