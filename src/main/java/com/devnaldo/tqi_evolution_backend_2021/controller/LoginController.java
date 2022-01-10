package com.devnaldo.tqi_evolution_backend_2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
;

@Controller

public class LoginController {


    @RequestMapping("/login")
    @GetMapping
    public String login(){

        return "login";
    }
}
