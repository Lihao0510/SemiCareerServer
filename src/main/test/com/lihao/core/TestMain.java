package com.lihao.core;

import com.alibaba.druid.filter.AutoLoad;
import com.lihao.entity.CareerLoginMessage;
import com.lihao.entity.ResponseObject;
import com.lihao.service.LoginServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lihao on 2017/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml", "classpath:spring/spring-cache.xml", "classpath:spring/spring-aop.xml", "classpath:spring/spring-redis.xml"})
public class TestMain {

    @Autowired
    LoginServiceTest loginServiceTest;

    @Test
    public void testLoginByPhone() {
        CareerLoginMessage response = (CareerLoginMessage) loginServiceTest.testLoginByPhone();
        System.out.println(response);
        assertNotNull(response);
    }
}
