package com.shalvin.messenger.repository;

import com.shalvin.messenger.entity.ConversationParticipant;
import com.shalvin.messenger.entity.ConversationParticipantId;
import com.shalvin.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ConversationParticipantsRepository extends JpaRepository<ConversationParticipant, ConversationParticipantId> {

    List<ConversationParticipant> getAllByUser_Username(String userUsername);

    @Query("from ConversationParticipant c where c.conversation.id in ?1")
    List<ConversationParticipant> getAllByConversationId(Set<Long> conversationIds);
}
