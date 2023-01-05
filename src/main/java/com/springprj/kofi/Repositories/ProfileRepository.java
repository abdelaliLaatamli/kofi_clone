package com.springprj.kofi.Repositories;

import com.springprj.kofi.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile , Long> {
}
