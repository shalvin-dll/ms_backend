package com.shalvin.messenger.controller;
//
//import com.example.chatserver.model.ChatMessage;
//import com.example.chatserver.service.UserSessionCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

//    @Autowired
//    private UserSessionCache userSessionCache;

    @MessageMapping("/chat.register")
    public void register(@Payload String chatMessage,
                         SimpMessageHeaderAccessor headerAccessor) {
//        String username = chatMessage.getSender();
//        String sessionId = headerAccessor.getSessionId();
//
//        // Save the username in the session
//        headerAccessor.getSessionAttributes().put("username", username);
//
//        // Add user to cache
//        userSessionCache.addUserSession(username, sessionId, null);
//
//        // Set message type to JOIN
//        chatMessage.setType(ChatMessage.MessageType.JOIN);
//        chatMessage.setContent(username + " joined the chat!");
//
//        // Broadcast to all users
//        messagingTemplate.convertAndSend("/topic/public", chatMessage);
//
//        logger.info("User {} registered with session {}", username, sessionId);
        logger.info(chatMessage);
    }

//    @MessageMapping("/chat.send")
//    public void sendMessage(@Payload ChatMessage chatMessage) {
//        String sender = chatMessage.getSender();
//        String recipient = chatMessage.getRecipient();
//
//        // Generate a unique ID for the message
//        chatMessage.setId(UUID.randomUUID().toString());
//
//        if (recipient != null && !recipient.isEmpty() && !recipient.equals("public")) {
//            // Private message
//            logger.info("Private message from {} to {}", sender, recipient);
//
//            // Send to recipient
//            messagingTemplate.convertAndSendToUser(
//                    recipient, "/queue/messages", chatMessage);
//
//            // Send a copy to sender
//            messagingTemplate.convertAndSendToUser(
//                    sender, "/queue/messages", chatMessage);
//        } else {
//            // Public message
//            logger.info("Public message from {}", sender);
//            messagingTemplate.convertAndSend("/topic/public", chatMessage);
//        }
//    }
//
//    @MessageMapping("/chat.typing")
//    public void notifyTyping(@Payload ChatMessage chatMessage) {
//        String sender = chatMessage.getSender();
//        String recipient = chatMessage.getRecipient();
//
//        // Set content to typing indicator
//        chatMessage.setContent(sender + " is typing...");
//
//        if (recipient != null && !recipient.isEmpty() && !recipient.equals("public")) {
//            // Private typing notification
//            messagingTemplate.convertAndSendToUser(
//                    recipient, "/queue/typing", chatMessage);
//        } else {
//            // Public typing notification
//            messagingTemplate.convertAndSend("/topic/typing", chatMessage);
//        }
//    }
}
