package com.soundmonster.soundmonster_backend.domain.user.entity;

import com.soundmonster.soundmonster_backend.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_username_is_active", columnList = "username, isActive")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "nickname", nullable = false, length = 10)
    private String nickname;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "userRole", nullable = false)
    private UserRole userRole;

    @Builder
    private User(String username, String password, String name, String email, String nickname, boolean isActive, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.userRole = userRole;
        this.isActive = isActive;
    }

    public static User of(String username, String password, String name, String email, String nickname, UserRole userRole, boolean isActive) {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .nickname(nickname)
                .userRole(userRole)
                .isActive(isActive)
                .build();
    }
}