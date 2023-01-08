package com.springprj.kofi.controllers;

import com.springprj.kofi.responses.GalleryResponse;
import com.springprj.kofi.services.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/gallary")
public class GalleryController
{

    private final GalleryService galleryService;
    @GetMapping("/profile/{profileId}")
    private ResponseEntity<List<GalleryResponse>> getGallaryByProfile(@PathVariable Long profileId){
        List<GalleryResponse> galleryResponseList = galleryService.getGalleryByProfileId(profileId);
        return ResponseEntity.ok(galleryResponseList);
    }
}
