package com.lihao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by lihao on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml", "classpath:spring/spring-cache.xml", "classpath:spring/spring-aop.xml", "classpath:spring/spring-redis.xml"})
public class CareerDaoTest {

    @Autowired
    CareerDao careerDao;

    @Test
    public void testPageQueryJobList() throws Exception {

    }

    @Test
    public void testGetJobDetailByID() throws Exception {

    }

    @Test
    public void testGetJobListByCompanyID() throws Exception {

    }
}