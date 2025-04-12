package com.shalvin.messenger.model;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
    private String username;
    private Date timestamp;
    private String message;
}
