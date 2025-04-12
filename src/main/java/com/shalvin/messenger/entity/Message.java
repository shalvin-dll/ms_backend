package com.shalvin.messenger.entity;

import com.shalvin.messenger.model.MessageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conversation_id", nullable = false, length = 50)
    private Long conversationId;

    @Column(name = "sender_username", nullable = false, length = 50)
    private String senderUsername;

    @ManyToOne
    @JoinColumn(name = "sender_username", referencedColumnName = "username", insertable = false, updatable = false)
    private User sender;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "media_url")
    private String mediaUrl;

    @Column(name = "message_type", length = 20)
    private String messageType = "TEXT";

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Column(name = "is_edited")
    private boolean isEdited = false;

    @Column(name = "delivered_at")
    private Date deliveredAt;

    @Column(name = "read_at")
    private Date readAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public MessageDTO toDTO() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setUsername(senderUsername);
        messageDTO.setMessage(messageText);
        messageDTO.setTimestamp(createdAt);
        return messageDTO;
    }
}
