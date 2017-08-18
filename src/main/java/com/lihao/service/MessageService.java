package com.lihao.service;

import com.lihao.dao.MessageDao;
import com.lihao.entity.CareerMessage;
import com.lihao.entity.ResponseObject;
import com.lihao.util.ResponseUtil;
import com.mysql.fabric.xmlrpc.base.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihao on 2017/8/18.
 */
@Service
public class MessageService {

    @Autowired
    MessageDao messageDao;

    public ResponseObject queryMessageByCondition(Map<String, Object> params) {
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        int pageNum = Integer.parseInt((String) params.get("pageNum"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        queryMap.put("start", pageNum * pageSize);
        queryMap.put("limit", pageSize);

        String messageSender = (String) params.get("messageSender");
        String messageReceiver = (String) params.get("messageReceiver");
        String messageType = (String) params.get("messageType");
        String messageTag = (String) params.get("messageTag");
        if (messageSender != null && !messageSender.equals("")) {
            queryMap.put("messageSender", messageSender);
        }
        if (messageReceiver != null && !messageReceiver.equals("")) {
            queryMap.put("messageReceiver", messageReceiver);
        }
        if (messageType != null && !messageType.equals("")) {
            queryMap.put("messageType", messageType);
        }
        if (messageTag != null && !messageTag.equals("")) {
            queryMap.put("messageTag", messageTag);
        }
        ResponseObject result = new ResponseObject();
        List<CareerMessage> messageList = null;

        try {
            messageList = messageDao.queryMessageByCondition(queryMap);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnList(messageList, result, "没有更多消息了");
        return result;
    }

    public ResponseObject writeMessage(CareerMessage message) {
        ResponseObject result = new ResponseObject();
        int resultCode = 0;
        try {
            resultCode = messageDao.writeMessage(message);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnInsertResult(resultCode, result);
        return result;
    }

    public ResponseObject deleteMessageByID(int messageID) {
        ResponseObject result = new ResponseObject();
        int resultCode = 0;
        try {
            resultCode = messageDao.deleteMessageByID(messageID);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnInsertResult(resultCode, result);
        return result;
    }

    public ResponseObject getMessageDetailByID(int messageID) {
        ResponseObject result = new ResponseObject();
        CareerMessage message = null;
        try {
            message = messageDao.getMessageDetailByID(messageID);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnObject(message, result, "没有指定的消息");
        return result;
    }

    public ResponseObject setMessageStatusByID(int messageID, int messageTag) {

        ResponseObject result = new ResponseObject();
        int resultCode = 0;
        try {
            resultCode = messageDao.setMessageStatusByID(messageID, messageTag);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnInsertResult(resultCode, result);
        return result;
    }

    public ResponseObject getMessageNumByTag(int messageID, int messageTag) {

        ResponseObject result = new ResponseObject();
        int num = 0;
        try {
            num = messageDao.getMessageCountByTag(messageID, messageTag);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        result.setStatus(1);
        result.setResult(num);
        return result;
    }

}
