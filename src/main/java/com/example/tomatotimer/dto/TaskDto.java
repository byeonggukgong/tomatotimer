package com.example.tomatotimer.dto;

import com.example.tomatotimer.domain.Task;
import lombok.*;

import javax.validation.constraints.NotEmpty;

public class TaskDto {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class CreateTask {

        @NotEmpty
        String content;

        @Builder
        public CreateTask(String content) {
            this.content = content;
        }

        public Task toEntity() {
            return Task.builder()
                .content(content)
                .build();
        }
    }
}
