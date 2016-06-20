/*
 * Copyright (c) 2016.
 */

package com.crooks;

/**
 * Created by johncrooks on 6/20/16.
 */
public class Message {
    Integer msgId;
    String msgText;

    public Message(Integer msgId, String msgText) {
        this.msgId = msgId;
        this.msgText = msgText;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
}
