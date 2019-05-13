package com.example.tomatotimer.service;

import com.example.tomatotimer.domain.User;
import com.example.tomatotimer.domain.UserRepository;
import com.example.tomatotimer.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public User getUserbyId(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User createdUser = userRepository.save(userDto.toEntity());

        return modelMapper.map(createdUser, UserDto.class);
    }
}
