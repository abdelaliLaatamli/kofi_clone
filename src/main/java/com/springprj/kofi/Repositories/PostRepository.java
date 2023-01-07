package com.springprj.kofi.Repositories;

import com.springprj.kofi.models.Post;
import com.springprj.kofi.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post , Long> {

    @Query( value = "SELECT * FROM post  where category = ?1", nativeQuery = true)
    List<Profile> findByCategoryId(Long CategoryId);

}
