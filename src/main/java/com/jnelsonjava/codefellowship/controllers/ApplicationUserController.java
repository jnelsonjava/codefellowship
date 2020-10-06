package com.jnelsonjava.codefellowship.controllers;

import com.jnelsonjava.codefellowship.models.user.ApplicationUser;
import com.jnelsonjava.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String showSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signupNewUser(String username, String password) {
        password = passwordEncoder.encode(password);
        ApplicationUser newUser = new ApplicationUser(username, password);
        applicationUserRepository.save(newUser);
        return new RedirectView("/");
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

//    reference for principal found at https://www.thymeleaf.org/doc/articles/layouts.html
    @GetMapping("/user")
    public RedirectView redirectToLoggedInUser(Principal principal) {
        System.out.println(principal);
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        return new RedirectView("/user/" + user.getId());
    }

    @GetMapping("/user/{id}")
    public String showSingleUser(Model mUser, @PathVariable long id) {
        System.out.println("in user route");
        System.out.println(id);
        ApplicationUser user = applicationUserRepository.getOne(id);
        System.out.println(user);
        mUser.addAttribute("user", user);
        return "user";
    }
}
