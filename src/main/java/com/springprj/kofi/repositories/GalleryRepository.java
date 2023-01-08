package com.springprj.kofi.repositories;

import com.springprj.kofi.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery,Long> {
    @Query( value = "SELECT * FROM gallery where profile_id = ?1", nativeQuery = true)
    List<Gallery> findByProfileId(Long profileId);

}
