package com.example.tomatotimer.task;

import com.example.tomatotimer.user.User;
import com.example.tomatotimer.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @GetMapping("/users/{userId}/tasks")
    public List<Task> getTaskByUser(@PathVariable Long userId) {
        return taskRepository.findByUser(
            userRepository.findById(userId)
                .orElseThrow(RuntimeException::new));
    }

    @GetMapping("/users/{userId}/tasks/{taskId}")
    public Task getTaskByUserAndId(
        @PathVariable Long userId, @PathVariable Long taskId) {

        User user = userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);

        return taskRepository.findByUserAndId(user, taskId)
            .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/users/{userId}/tasks")
    public Task createTask(
        @PathVariable Long userId, @RequestBody @Valid Task newTask) {

        User user = userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);

        Task task = Task.builder()
            .user(user)
            .content(newTask.getContent())
            .build();

        return taskRepository.save(task);
    }
}
