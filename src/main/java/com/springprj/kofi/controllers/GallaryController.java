package com.springprj.kofi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/gallary")
public class GallaryController
{

    @GetMapping("/profile/{profileId}")
    private String getGallaryByProfile(@PathVariable Long profileId){
        return "aaaaa" + profileId;
    }
}
