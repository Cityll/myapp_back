package com.example.myapp.controller;

import com.example.myapp.model.User;
import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "회원가입 성공!";
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());
        return optionalUser.orElseThrow(() -> new IllegalArgumentException("이메일이 존재하지 않습니다."));
    }
}
