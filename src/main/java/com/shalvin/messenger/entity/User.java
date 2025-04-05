package com.shalvin.messenger.entity;

import com.shalvin.messenger.enums.Role;
import com.shalvin.messenger.model.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "users")
@Data
@Entity
public class User {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "status")
    private String status;

    @Column(name = "last_seen")
    private Date lastSeen;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUsername(username);
        userDTO.setName(name);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setEmail(email);
        userDTO.setRole(role);
        userDTO.setProfilePicture(profilePicture);
        userDTO.setStatus(status);
        userDTO.setLastSeen(lastSeen);
        return userDTO;
    }
}

