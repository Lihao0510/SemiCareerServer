package com.lihao.entity;

/**
 * Created by lihao on 2017/8/17.
 */
public class CareerMessage {

    public int messageID;
    public int messageReceiver;
    public int messageCompany;
    public int messageSender;
    public int messageType;
    public int messageTag;
    public String messageTitle;
    public String messageText;
    public String messageUrl;
    public String messageTime;
    public SysUser senderMessage;
    public SysUser receiverMessage;

    public int getMessageID() {
        return messageID;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getMessageReceiver() {
        return messageReceiver;
    }

    public void setMessageReceiver(int messageReceiver) {
        this.messageReceiver = messageReceiver;
    }

    public int getMessageCompany() {
        return messageCompany;
    }

    public void setMessageCompany(int messageCompany) {
        this.messageCompany = messageCompany;
    }

    public int getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(int messageSender) {
        this.messageSender = messageSender;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getMessageTag() {
        return messageTag;
    }

    public void setMessageTag(int messageTag) {
        this.messageTag = messageTag;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public SysUser getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(SysUser senderMessage) {
        this.senderMessage = senderMessage;
    }

    public SysUser getReceiverMessage() {
        return receiverMessage;
    }

    public void setReceiverMessage(SysUser receiverMessage) {
        this.receiverMessage = receiverMessage;
    }

    @Override
    public String toString() {
        return "CareerMessage{" +
                "messageID=" + messageID +
                ", messageReceiver=" + messageReceiver +
                ", messageCompany=" + messageCompany +
                ", messageSender=" + messageSender +
                ", messageType=" + messageType +
                ", messageTag=" + messageTag +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageUrl='" + messageUrl + '\'' +
                ", senderMessage=" + senderMessage +
                ", receiverMessage=" + receiverMessage +
                '}';
    }
}
