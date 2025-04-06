package com.shalvin.messenger.repository;

import com.shalvin.messenger.entity.ConversationParticipant;
import com.shalvin.messenger.entity.ConversationParticipantId;
import com.shalvin.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationParticipantsRepository extends JpaRepository<ConversationParticipant, ConversationParticipantId> {

    List<ConversationParticipant> getAllByUser_Username(String userUsername);
}
