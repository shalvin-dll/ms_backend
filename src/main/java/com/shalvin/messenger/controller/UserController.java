package com.shalvin.messenger.controller;

import com.shalvin.messenger.model.HomeChatModel;
import com.shalvin.messenger.response.BaseResponse;
import com.shalvin.messenger.service.MessagingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final MessagingService messagingService;

    public UserController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @GetMapping("/homepage/{username}")
    public BaseResponse<List<HomeChatModel>> homepage(@PathVariable String username) {
        return messagingService.getAllMessagesForHomePage(username);
    }
}
