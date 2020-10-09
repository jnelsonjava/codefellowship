package com.jnelsonjava.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String renderHome(Model m, Principal principal) {
        m.addAttribute("principal", principal);
        return "home";
    }
}
