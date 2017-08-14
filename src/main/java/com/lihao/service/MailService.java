package com.lihao.service;

import com.lihao.dao.EmailDao;
import com.lihao.entity.InnerMail;
import com.lihao.entity.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lihao on 2017/8/13.
 */
@Service
public class MailService {

    @Autowired
    EmailDao mailDao;

    public ResponseObject getMailList() {
        ResponseObject result = new ResponseObject();
        List<InnerMail> mailList = null;
        try {
            mailList = mailDao.getEmailListBySender(10012);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        if (mailList != null || mailList.size() > 0) {
            result.setStatus(1);
            result.setResult(mailList);
        } else {
            result.setStatus(0);
            result.setErrorMsg("没有邮件!");
        }
        return result;
    }

}
