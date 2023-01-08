package com.springprj.kofi.services;

import com.springprj.kofi.repositories.GalleryRepository;
import com.springprj.kofi.models.Gallery;
import com.springprj.kofi.responses.GalleryResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class GalleryService {
    private final GalleryRepository galleryRepository;

    private final ModelMapper modelMapper;

    public List<GalleryResponse> getGalleryByProfileId(Long profileId){
        List<Gallery> galleryList = galleryRepository.findByProfileId(profileId);

        List<GalleryResponse> galleryResponsesList = galleryList
                .stream()
                .map(gallery -> modelMapper.map(gallery,GalleryResponse.class) )
                .collect(Collectors.toList());

        return galleryResponsesList;
    }

}
