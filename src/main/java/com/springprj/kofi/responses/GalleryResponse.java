package com.springprj.kofi.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class GalleryResponse {
    private Long id;
    private String title;
    private String details;

    private String image;
}
