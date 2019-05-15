package com.example.tomatotimer.dto;

import com.example.tomatotimer.domain.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private Long id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
            .email(email)
            .password(password)
            .build();
    }
}
