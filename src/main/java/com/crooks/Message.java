/*
 * Copyright (c) 2016.
 */

package com.crooks;

import javax.persistence.*;

/**
 * Created by johncrooks on 6/20/16.
 */
@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue
    int msgId;

    @Column(nullable = false)
    String msgText;

    public Message(int msgId, String msgText) {
        this.msgId = msgId;
        this.msgText = msgText;
    }

    public Message(String msgText) {
        this.msgText = msgText;
    }

    public Message() {
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

}
