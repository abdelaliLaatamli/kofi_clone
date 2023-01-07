package com.springprj.kofi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    @GetMapping("/profile/{profileId}")
    private String allProfilePosts(@PathVariable Long profileId ){
        return "aaaaa" + profileId;
    }


}
