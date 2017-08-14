package com.lihao.dao;

import com.lihao.entity.InnerMail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihao on 2017/8/13.
 */
@Repository
public interface EmailDao {

    List<InnerMail> getEmailListByReceiver(int receiverID);

    List<InnerMail> getEmailListBySender(int senderID);

    InnerMail getMailMessageByID(int mailID);

}
