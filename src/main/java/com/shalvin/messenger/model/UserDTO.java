package com.shalvin.messenger.model;

import com.shalvin.messenger.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private Role role;
    private String profilePicture;
    private String status;
    private LocalDateTime lastSeen;
}
