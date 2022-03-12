package com.demorealworld.user;

import com.demorealworld.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<RegisterForm> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveNewUser(userDTO.getUser()));
    }
}
