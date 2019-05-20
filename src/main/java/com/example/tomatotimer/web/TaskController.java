package com.example.tomatotimer.web;

import com.example.tomatotimer.dto.TaskDto;
import com.example.tomatotimer.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/tasks")
    public String createTask(@ModelAttribute TaskDto.CreateTask createTaskDto, Principal principal) {
        taskService.createTask(principal.getName(), createTaskDto);

        return "redirect:/";
    }
}
