package com.springprj.kofi.controllers;

import com.springprj.kofi.models.Profile;
import com.springprj.kofi.responses.ProfileResponse;
import com.springprj.kofi.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {


    private final ProfileService profileService;
    @GetMapping
    private ResponseEntity< List<ProfileResponse>> allProfiles(){
        List<ProfileResponse> profileList = profileService.getAllProfiles();
        return ResponseEntity.ok(profileList);
    }


    @GetMapping("/category/{categoryId}")
    private ResponseEntity<List<ProfileResponse>> categoryProfiles(@PathVariable Long categoryId ){
        List<ProfileResponse> profileList = profileService.getAllProfileByCategory(categoryId);
        return ResponseEntity.ok( profileList );
    }

    @GetMapping("/{profileId}")
    private ResponseEntity<ProfileResponse> getProfileDetails(@PathVariable Long profileId){
        ProfileResponse profile= profileService.getProfileDetails(profileId);
        return ResponseEntity.ok(profile);
    }

}
