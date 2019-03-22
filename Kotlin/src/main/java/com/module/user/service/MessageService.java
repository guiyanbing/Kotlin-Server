package com.module.user.service;

import com.module.user.model.MessageInfo;

import java.util.List;

public interface MessageService {
    int addMessage(MessageInfo paramMessageInfo);

    List<MessageInfo> getMessageList(Integer paramInteger);
}
