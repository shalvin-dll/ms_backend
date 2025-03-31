package com.shalvin.messenger.entity;

import com.shalvin.messenger.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table("users")
@Data
public class User {

    @Id
    private Long id;

    @Column("username")
    private String username;

    @Column("name")
    private String name;

    @Column("phone_number")
    private String phoneNumber;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("role")
    private Role role;

    @Column("profile_picture")
    private String profilePicture;

    @Column("status")
    private String status;

    @Column("last_seen")
    private LocalDateTime lastSeen;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}

