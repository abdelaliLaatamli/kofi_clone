package com.springprj.kofi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Firstcontroller {

    @GetMapping
    private String test(){
        return "test";
    }
}
