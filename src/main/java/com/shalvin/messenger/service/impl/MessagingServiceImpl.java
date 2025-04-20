package com.shalvin.messenger.service.impl;

import com.shalvin.messenger.dao.MessageDao;
import com.shalvin.messenger.dao.UserDao;
import com.shalvin.messenger.entity.ConversationParticipant;
import com.shalvin.messenger.entity.Message;
import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.model.HomeChatModel;
import com.shalvin.messenger.model.MessageDTO;
import com.shalvin.messenger.response.BaseResponse;
import com.shalvin.messenger.service.MessagingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessagingServiceImpl implements MessagingService {
    private final MessageDao messageDao;
    private final UserDao userDao;

    public MessagingServiceImpl(MessageDao messageDao, UserDao userDao) {
        this.messageDao = messageDao;
        this.userDao = userDao;
    }

    public BaseResponse<List<HomeChatModel>> getAllMessagesForHomePage(String username) {
        List<ConversationParticipant> conversationParticipants = messageDao.getAllConversationsForUser(username);
        Set<Long> conversationIds = conversationParticipants.parallelStream()
                .map(convo -> convo.getConversation().getId()).collect(Collectors.toSet());
        List<ConversationParticipant> conversations = messageDao.getAllConversationsFromIds(conversationIds);
        return new BaseResponse<>(true, conversations
                .parallelStream()
                .filter(conversationParticipant -> !conversationParticipant.getUser().getUsername().equals(username))
                .map(convo -> HomeChatModel.builder().name(convo.getUser().getName())
                        .conversationId(convo.getConversation().getId())
                        .username(convo.getUser().getUsername())
                        .build())
                .toList());
    }

    public BaseResponse<List<MessageDTO>> getAllMessagesForUser(Long conversationId) {
        return new BaseResponse<>(true, messageDao.getByConversationId(conversationId)
                .stream()
                .map(Message::toDTO)
                .toList());

    }



}
