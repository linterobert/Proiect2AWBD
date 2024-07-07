package com.example.UserProject.controllers;

import com.example.UserProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/report_headers")
    public String getReportHeaders() {
        return userService.getReportHeaders("BALANCE_SHEET");
    }

    @GetMapping("/pet_id/{id}")
    public String getPetImage(@PathVariable("id") int id) { return userService.getPetImageById(id); }
}
