package com.lihao.service;

import com.lihao.dao.NoticeDao;
import com.lihao.entity.EnterpriseNotice;
import com.lihao.entity.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lihao on 2017/8/8.
 */
@Service
public class NoticeService {

    @Autowired
    NoticeDao noticeDao;

    public ResponseObject getAllNotice() {
        ResponseObject result = new ResponseObject();
        List<EnterpriseNotice> noticeList = null;
        try {

            noticeList = noticeDao.getAllNotice();
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        if (noticeList != null || noticeList.size() > 0) {
            result.setStatus(1);
            result.setResult(noticeList);
        } else {
            result.setStatus(0);
            result.setErrorMsg("没有公告!");
        }
        return result;
    }

}
