package com.lihao.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lihao on 2017/8/13.
 */
public class InnerMail {

    public int mailID;
    public int senderID;
    public int mailStatus;
    public int mailTag;
    public SysUser sender;
    public String mailTitle;
    public String mailContent;
    public String mailExtra;
    public String mailSendTime;
    public List<String> attachmentUrl;
    public List<SysUser> carbonCopyList;
    public List<SysUser> receiverList;

    public InnerMail(int mailID) {
        this.mailID = mailID;
    }

    public int getMailID() {
        return mailID;
    }

    public void setMailID(int mailID) {
        this.mailID = mailID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(int mailStatus) {
        this.mailStatus = mailStatus;
    }

    public int getMailTag() {
        return mailTag;
    }

    public void setMailTag(int mailTag) {
        this.mailTag = mailTag;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailExtra() {
        return mailExtra;
    }

    public void setMailExtra(String mailExtra) {
        this.mailExtra = mailExtra;
    }

    public String getMailSendTime() {
        return mailSendTime;
    }

    public void setMailSendTime(String mailSendTime) {
        this.mailSendTime = mailSendTime;
    }

    public List<String> getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(List<String> attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public List<SysUser> getCarbonCopyList() {
        return carbonCopyList;
    }

    public void setCarbonCopyList(List<SysUser> carbonCopyList) {
        this.carbonCopyList = carbonCopyList;
    }

    public List<SysUser> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<SysUser> receiverList) {
        this.receiverList = receiverList;
    }

    @Override
    public String toString() {
        return "InnerMail{" +
                "mailID=" + mailID +
                ", senderID=" + senderID +
                ", mailStatus=" + mailStatus +
                ", mailTag=" + mailTag +
                ", sender=" + sender +
                ", mailTitle='" + mailTitle + '\'' +
                ", mailContent='" + mailContent + '\'' +
                ", mailExtra='" + mailExtra + '\'' +
                ", mailSendTime='" + mailSendTime + '\'' +
                ", attachmentUrl=" + attachmentUrl +
                ", carbonCopyList=" + carbonCopyList +
                ", receiverList=" + receiverList +
                ", receiverListSize:" + receiverList.size() +
                ", carbonCopyListSize:" + carbonCopyList.size() +
                '}';
    }
}
