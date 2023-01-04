package com.springprj.kofi.Repositories;

import com.springprj.kofi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findbyEmail(String email);
}
