package com.shalvin.messenger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationParticipantId implements Serializable {
    @Column(name = "conversation_id")
    private Long conversationId;

    @Column(name = "user_id")
    private String userId;
}
