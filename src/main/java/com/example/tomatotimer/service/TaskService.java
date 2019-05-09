package com.example.tomatotimer.service;

import com.example.tomatotimer.domain.Task;
import com.example.tomatotimer.domain.TaskRepository;
import com.example.tomatotimer.domain.User;
import com.example.tomatotimer.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public List<Task> getTaskByUser(Long userId) {
        return taskRepository.findByUser(
            userRepository.findById(userId)
                .orElseThrow(RuntimeException::new));
    }

    public Task getTaskByUserAndId(Long userId, Long taskId) {
        User user = userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);

        return taskRepository.findByUserAndId(user, taskId)
            .orElseThrow(RuntimeException::new);
    }

    public Task createTask(Long userId, Task newTask) {
        User user = userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);

        Task task = Task.builder()
            .user(user)
            .content(newTask.getContent())
            .build();

        return taskRepository.save(task);
    }
}
