package com.springprj.kofi.repositories;

import com.springprj.kofi.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile , Long> {
    // List<Profile> findAllByCategory(Long categoryId);
    @Query( value = "SELECT * FROM profile  where category = ?1", nativeQuery = true)
    List<Profile> findByCategoryId(Long CategoryId);
}
