package com.example.tomatotimer.web;

import com.example.tomatotimer.dto.UserDto;
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
    public String logIn() {
        return "/users/login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "/users/signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute @Valid UserDto userDto) {
        userService.signUp(userDto);

        return "redirect:/login";
    }
}
