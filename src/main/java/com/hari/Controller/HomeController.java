package com.hari.Controller;

import com.hari.Entities.User;
import com.hari.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser() {
        return userService.getUsers();
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/current")
    public String getLoggedUser(Principal principal) {
        return principal.getName();

    }

}
