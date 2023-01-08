package com.springprj.kofi.controllers;

import com.springprj.kofi.models.Post;
import com.springprj.kofi.responses.PostResponse;
import com.springprj.kofi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;
    @GetMapping("/profile/{profileId}")
    private ResponseEntity<List<PostResponse>> allProfilePosts(@PathVariable Long profileId ){
        List<PostResponse> postList = postService.getPostsByProfileId( profileId );
        return ResponseEntity.ok( postList );
    }


}
