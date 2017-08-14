package com.lihao.dao;

import com.lihao.entity.InnerMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lihao on 2017/8/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml", "classpath:spring/spring-cache.xml", "classpath:spring/spring-aop.xml", "classpath:spring/spring-redis.xml"})
public class EmailDaoTest {

    @Autowired
    EmailDao emailDao;

    @Test
    public void testGetEmailListBySender() throws Exception {
        List<InnerMail> emailList = emailDao.getEmailListBySender(10012);
        for (InnerMail mail : emailList) {
            System.out.println(mail.toString());
        }
    }
}