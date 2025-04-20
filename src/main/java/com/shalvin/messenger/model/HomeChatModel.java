package com.shalvin.messenger.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HomeChatModel {
    private String name;
    private String username;
    private Long conversationId;
    private String lastMessage;
    private int unreadCount;
    private String profileImageUrl;
    private String time;
}
