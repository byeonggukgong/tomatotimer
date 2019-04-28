package com.example.tomatotimer.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }
}
