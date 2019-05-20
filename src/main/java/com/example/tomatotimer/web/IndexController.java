package com.example.tomatotimer.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("isAuthenticated", principal);

        return "index";
    }
}
