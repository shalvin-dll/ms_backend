package com.shalvin.messenger.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "conversation_participants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationParticipant {
    @EmbeddedId
    private ConversationParticipantId id;

    @ManyToOne
    @MapsId("conversationId")
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "username", insertable = false, updatable = false)
    private User user;

    @Column(name = "is_admin")
    private boolean isAdmin = false;

    @Column(name = "joined_at")
    private Date joinedAt;

    @Column(name = "left_at")
    private Date leftAt;

    @Column(name = "is_muted")
    private boolean isMuted = false;

    @PrePersist
    protected void onCreate() {
        joinedAt = new Date();
    }
}
