package com.example.tomatotimer.service;

import com.example.tomatotimer.domain.User;
import com.example.tomatotimer.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserbyId(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
