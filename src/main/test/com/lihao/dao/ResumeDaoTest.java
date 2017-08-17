package com.lihao.dao;

import com.lihao.entity.CareerResume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by lihao on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml", "classpath:spring/spring-cache.xml", "classpath:spring/spring-aop.xml", "classpath:spring/spring-redis.xml"})
public class ResumeDaoTest {

    @Autowired
    ResumeDao resumeDao;

    @Test
    public void testGetResumeByUserID() throws Exception {
        CareerResume resume = resumeDao.getResumeByUserID(10002);
        System.out.println(resume.toString());
        assertNotNull(resume);
    }

    @Test
    public void testCreateResume() throws Exception {
        CareerResume resume = new CareerResume();
        resume.userID = 10005;
        resume.userSign = "我是一个程序员,咿呀咿呀哟!";
        resume.userHead = "http://www.iteye.com/upload/logo/user/725262/dc0a6022-57fe-3413-92c6-27a57bb6cd9c.png?1345314657";
        resume.userAdvance = "我会做菜!";
        resume.intentCity = "021";
        resume.intentBusiness = 0;
        resume.intentJob = "前端工程师";
        resume.careerYear = 2;
        resume.highistDegree = 2;
        resume.userDesc = "我很牛B";
        resume.userSchool = "清华大学";
        resume.userProfessor = "计算机科学与技术";
        resume.userBirth = "1997-02-25";
        resume.userSex = 1;
        resume.userAttach = "";
        int result = resumeDao.createResume(resume);
        System.out.println("Result" + result);
        System.out.println(resume);
        assertEquals(result, 1);
    }

    @Test
    public void testUpdateResume() throws Exception {
        CareerResume resume = new CareerResume();
        resume.resumeID = 10002;
        resume.userID = 10005;
        resume.userSign = "我是一个PVD工程师,咿呀咿呀哟!";
        resume.userHead = "http://www.iteye.com/upload/logo/user/725262/dc0a6022-57fe-3413-92c6-27a57bb6cd9c.png?1345314657";
        resume.userAdvance = "我会做爱!";
        resume.intentCity = "021";
        resume.intentBusiness = 0;
        resume.intentJob = "PVD工程师";
        resume.careerYear = 2;
        resume.highistDegree = 2;
        resume.userDesc = "这才是真正的自我介绍";
        resume.userSchool = "北京大学";
        resume.userProfessor = "计算机科学与技术";
        resume.userBirth = "1997-02-25";
        resume.userSex = 1;
        resume.userAttach = "";
        int result = resumeDao.updateResume(resume);
        assertEquals(result, 1);
        System.out.println(resume);
    }

    @Test
    public void testDeleteResume() throws Exception {
        int result = resumeDao.deleteResume(10002);
        assertEquals(result, 1);
    }
}