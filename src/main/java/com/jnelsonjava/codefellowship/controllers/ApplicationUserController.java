package com.jnelsonjava.codefellowship.controllers;

import com.jnelsonjava.codefellowship.models.user.ApplicationUser;
import com.jnelsonjava.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Date;
import java.util.List;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String showSignup(Model m, Principal principal) {
        m.addAttribute("principal", principal);
        return "signup";
    }

    @PostMapping("/signup")
    public ModelAndView signupNewUser(HttpServletRequest request, String username, String password, String email, String firstName, String lastName, String dateOfBirth, String bio) {
        password = passwordEncoder.encode(password);
        ApplicationUser newUser = new ApplicationUser(username, password, email);
        if (firstName != "") newUser.setFirstName(firstName);
        if (lastName != "") newUser.setLastName(lastName);
        // reference for date conversion https://www.javatpoint.com/java-sql-date
        if (dateOfBirth != "") newUser.setDateOfBirth(Date.valueOf(dateOfBirth));
        if (bio != "") newUser.setBio(bio);
        applicationUserRepository.save(newUser);
//        return new RedirectView("/");
        // reference for redirecting a POST request to a POST route: https://www.baeldung.com/spring-redirect-and-forward
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public String showLogin(Model m, Principal principal) {
        m.addAttribute("principal", principal);
        return "login";
    }

    @GetMapping("/user/{id}")
    public String showSingleUser(Model m, Principal principal, @PathVariable long id) {
        System.out.println("in user route");
        System.out.println(id);
        ApplicationUser user = applicationUserRepository.getOne(id);
        m.addAttribute("user", user);
        m.addAttribute("principal", principal);
        return "user";
    }

//    reference for principal found at https://www.thymeleaf.org/doc/articles/layouts.html
    @GetMapping("/myprofile")
    public String renderProfile(Model m, Principal principal) {
        ApplicationUser user = applicationUserRepository.findByUsername(principal.getName());
        List<ApplicationUser> allUsers = applicationUserRepository.findAll();
        m.addAttribute("user", user);
        m.addAttribute("principal", principal);
        m.addAttribute("allUsers", allUsers);
        return "myprofile";
    }

}
