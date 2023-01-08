package com.springprj.kofi.services;

import com.springprj.kofi.repositories.PostRepository;
import com.springprj.kofi.models.Post;
import com.springprj.kofi.responses.GalleryResponse;
import com.springprj.kofi.responses.PostResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    public List<PostResponse> getPostsByProfileId(Long profileId){
        List<Post> postList = postRepository.findByProfileId(profileId);

        List<PostResponse> postResponsesList = postList
                .stream()
                .map(post -> modelMapper.map(post,PostResponse.class) )
                .collect(Collectors.toList());
        return postResponsesList;
    }

}
