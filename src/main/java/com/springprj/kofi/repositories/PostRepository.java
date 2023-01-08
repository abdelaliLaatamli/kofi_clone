package com.springprj.kofi.repositories;

import com.springprj.kofi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post , Long> {

    @Query( value = "SELECT * FROM post where profile_id = ?1", nativeQuery = true)
    List<Post> findByProfileId(Long profileId);

}
