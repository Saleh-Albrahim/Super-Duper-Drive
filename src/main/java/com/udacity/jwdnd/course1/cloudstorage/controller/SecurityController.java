package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    // Render the login page
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }


}
