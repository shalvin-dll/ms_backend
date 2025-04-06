package com.shalvin.messenger.service.impl;

import com.shalvin.messenger.dao.MessageDao;
import com.shalvin.messenger.dao.UserDao;
import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.model.HomeChatModel;
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
        Optional<User> user = userDao.findByUsername(username);
        if (user.isPresent()) {
            Set<Long> convIds = messageDao.getAllConversationsForUser(user.get())
                    .stream()
                    .filter(conversationParticipant -> !conversationParticipant.getConversation().isGroup())
                    .map(conversationParticipant -> conversationParticipant.getId().getConversationId())
                    .collect(Collectors.toSet());

            return new BaseResponse<>(true, userDao.findAllByUsernames(messageDao.getAllMessagesForConversationIds(convIds))
                    .stream()
                    .filter(sender -> !sender.getUsername().equals(username))
                    .map(sender ->HomeChatModel.builder().username(sender.getUsername()).name(sender.getName())
                            .lastMessage("This is last message").build()).toList());
        } else {
            return new BaseResponse<>(false, new ArrayList<>());
        }
    }



}
