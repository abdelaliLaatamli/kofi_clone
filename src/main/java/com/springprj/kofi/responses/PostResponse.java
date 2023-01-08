package com.springprj.kofi.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class PostResponse {
    private Long id;
    private String title;
    private String details;
    private List<CommentResponse> comments;
}
