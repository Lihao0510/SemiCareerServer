package com.lihao.dao;

import com.lihao.entity.CareerNews;
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
public class NewsDaoTest {

    @Autowired
    NewsDao newsDao;

    @Test
    public void testQueryNewsByCondition() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", 0);
        params.put("limit", 5);
        List<CareerNews> newsList = newsDao.queryNewsByCondition(params);
        assertNotNull(params);
        System.out.println(newsList);
    }

    @Test
    public void testGetNewsByID() throws Exception {
        CareerNews news = newsDao.getNewsByID(100003);
        assertNotNull(news);
        System.out.println(news);
    }

    @Test
    public void testAddCommentByNewsID() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("newsID", 100003);
        params.put("userID", 10009);
        params.put("commentText", "希望祖国的面板事业越来越好");
        int result = newsDao.addCommentByNewsID(params);
        assertNotEquals(result, 0);
    }
}