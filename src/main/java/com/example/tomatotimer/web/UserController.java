package com.example.tomatotimer.web;

import com.example.tomatotimer.domain.User;
import com.example.tomatotimer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/users/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/users/signup";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute @Valid User user) {
        userService.createUser(user);

        return "redirect:/login";
    }
}
