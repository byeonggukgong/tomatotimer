package com.example.tomatotimer.web;

import com.example.tomatotimer.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final TaskService taskService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("isAuthenticated", principal);

        if(principal != null) {
            log.info("인증되어있습니다. {}", principal.getName());

            model.addAttribute("tasks", taskService.getTasksByEmail(principal.getName()));
        }

        return "index";
    }
}
