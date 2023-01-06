package com.springprj.kofi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {


    @GetMapping
    private String allProfiles(){
        return "aaaa";
    }


    @GetMapping("/category/{categoryid}")
    private String categoryProfiles(){
        return "aaaa";
    }

}
