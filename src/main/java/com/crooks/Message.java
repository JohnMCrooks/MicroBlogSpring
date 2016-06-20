/*
 * Copyright (c) 2016.
 */

package com.crooks;

/**
 * Created by johncrooks on 6/20/16.
 */
public class Message {
    int msgId;
    String msgText;

    public Message(int msgId, String msgText) {
        this.msgId = msgId;
        this.msgText = msgText;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
}
