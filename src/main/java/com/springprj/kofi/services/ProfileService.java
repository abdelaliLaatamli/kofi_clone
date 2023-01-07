package com.springprj.kofi.services;

import com.springprj.kofi.Repositories.ProfileRepository;
import com.springprj.kofi.models.Profile;
import com.springprj.kofi.responses.ProfileResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public List<ProfileResponse> getAllProfiles(){
        List<Profile> profileList =  profileRepository.findAll();
        List<ProfileResponse> profileResponseList = new ArrayList<>();
        for(Profile profile: profileList){
            profileResponseList.add(
                    ProfileResponse.builder()
                            .id(profile.getId())
                            .nickname(profile.getNickname())
                            .avatar(profile.getAvatar())
                            .description(profile.getDescription())
                            .follows(profile.getFollows().size())
                            .build());
        }


        return profileResponseList;
    }

    public List<ProfileResponse> getAllProfileByCategory( Long categoryId){
        List<Profile> profileList =  profileRepository.findByCategoryId(categoryId);
        List<ProfileResponse> profileResponseList = new ArrayList<>();
        for(Profile profile: profileList){
            profileResponseList.add(
                    ProfileResponse.builder()
                            .id(profile.getId())
                            .nickname(profile.getNickname())
                            .avatar(profile.getAvatar())
                            .description(profile.getDescription())
                            .follows(profile.getFollows().size())
                            .build());
        }
        //System.out.println(profileList.size());
        return profileResponseList;
    }


    public ProfileResponse getProfileDetails(Long profileId){
        Profile profile = profileRepository
                    .findById(profileId)
                    .orElseThrow(() -> new RuntimeException("Profile not found"));

        ProfileResponse profileResponse = ProfileResponse.builder()
                .id(profile.getId())
                .nickname(profile.getNickname())
                .avatar(profile.getAvatar())
                .description(profile.getDescription())
                .follows(profile.getFollows().size())
                .build();

        return profileResponse;
    }

}
