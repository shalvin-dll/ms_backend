package com.shalvin.messenger.dao;

import com.shalvin.messenger.entity.ConversationParticipant;
import com.shalvin.messenger.entity.Message;
import com.shalvin.messenger.entity.User;
import com.shalvin.messenger.repository.ConversationParticipantsRepository;
import com.shalvin.messenger.repository.MessageRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MessageDao {

    private final ConversationParticipantsRepository conversationParticipantsRepository;
    private final MessageRepository messageRepository;

    public MessageDao(ConversationParticipantsRepository conversationParticipantsRepository, MessageRepository messageRepository) {
        this.conversationParticipantsRepository = conversationParticipantsRepository;
        this.messageRepository = messageRepository;
    }

    public List<ConversationParticipant> getAllConversationsForUser(User user) {
        return conversationParticipantsRepository.getAllByUser_Username(user.getUsername());
    }

    public List<String> getAllMessagesForConversationIds(Set<Long> conversationIds) {
        return messageRepository.findUsersByConversationIds(conversationIds);
    }

}
