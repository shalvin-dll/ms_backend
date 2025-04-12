package com.shalvin.messenger.service;

import com.shalvin.messenger.model.HomeChatModel;
import com.shalvin.messenger.model.MessageDTO;
import com.shalvin.messenger.response.BaseResponse;

import java.util.List;

public interface MessagingService {
    BaseResponse<List<HomeChatModel>> getAllMessagesForHomePage(String username);

    public BaseResponse<List<MessageDTO>> getAllMessagesForUser(Long conversationId);
}
