package com.example.tomatotimer.dto;

import com.example.tomatotimer.domain.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private Long id;

    @NotBlank
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public UserDto(String email) {
        this.email = email;
    }

    public User toEntity() {
        return User.builder()
            .email(email)
            .build();
    }
}
