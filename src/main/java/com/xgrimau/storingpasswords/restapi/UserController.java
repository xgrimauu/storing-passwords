package com.xgrimau.storingpasswords.restapi;

import com.xgrimau.storingpasswords.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody NewUserRequest userRequest) {
        userService.registerUser(userRequest.username, userRequest.password);
    }
}
