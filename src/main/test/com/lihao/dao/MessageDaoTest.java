package com.lihao.dao;

import com.lihao.entity.CareerMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lihao on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml", "classpath:spring/spring-cache.xml", "classpath:spring/spring-aop.xml", "classpath:spring/spring-redis.xml"})
public class MessageDaoTest {

    @Autowired
    MessageDao messageDao;

    @Test
    public void testQueryMessageByCondition() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", 0);
        params.put("limit", 5);
        params.put("messageReceiver", 10002);

        List<CareerMessage> messageList = messageDao.queryMessageByCondition(params);
        System.out.println(messageList);
        assertNotNull(messageList);
    }

    @Test
    public void testWriteMessage() throws Exception {
        CareerMessage message = new CareerMessage();
        message.messageSender = 10012;
        message.messageReceiver = 10008;
        message.messageTitle = "吊丝公司的王妮金发来一条消息!";
        message.messageText = "你好,有兴趣加入我们吊丝公司吗?";
        message.messageCompany = 100002;
        message.messageUrl = "";

        int result = messageDao.writeMessage(message);
        System.out.println("Result:" + result);
        System.out.println(message);
    }

    @Test
    public void testDeleteMessageByID() throws Exception {
        int result = messageDao.deleteMessageByID(100003);
    }
}