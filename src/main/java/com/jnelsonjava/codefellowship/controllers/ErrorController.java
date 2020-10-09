package com.jnelsonjava.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        int status = Integer.parseInt((request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString()));
        model.addAttribute("status", status);
        return "error";
    }

}
