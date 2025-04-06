package com.shalvin.messenger.repository;

import com.shalvin.messenger.entity.Message;
import com.shalvin.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversationIdIn(Collection<String> conversationIds);

    @Query("select m.senderUsername from Message m where m.conversationId in ?1 group by m.senderUsername")
    List<String> findUsersByConversationIds(Set<Long> conversationIds);
}
