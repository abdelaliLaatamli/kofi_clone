package com.springprj.kofi.services;

import com.springprj.kofi.repositories.PostRepository;
import com.springprj.kofi.models.Post;
import com.springprj.kofi.responses.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {


    private final PostRepository postRepository;
    public List<PostResponse> getPostsByProfileId(Long profileId){
        List<Post> postList = postRepository.findByProfileId(profileId);
        List<PostResponse> postResponsesList = new ArrayList<>();
        for ( Post post: postList ){
            postResponsesList.add(
                    PostResponse.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .details(post.getDetails())
                            .build()

            );

        }
        return postResponsesList;
    }

}
