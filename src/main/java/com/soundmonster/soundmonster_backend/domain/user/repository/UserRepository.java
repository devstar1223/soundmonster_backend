package com.soundmonster.soundmonster_backend.domain.user.repository;

import com.soundmonster.soundmonster_backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndIsActiveTrue(String username);
    Optional<User> findByEmailAndIsActiveTrue(String email);
    Optional<User> findByNicknameAndIsActiveTrue(String nickname);
}
