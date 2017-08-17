package com.lihao.dao;

import com.lihao.entity.CareerCompany;
import com.lihao.entity.CareerJob;
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
        List<CareerJob> jobList = careerDao.pageQueryJobList(0, 4);
        assertEquals(jobList.size(), 4);
        System.out.println(jobList.toString());
    }


    @Test
    public void testGetJobListByCompanyID() throws Exception {
        List<CareerJob> jobList = careerDao.getJobListByCompanyID(100001);
        System.out.println(jobList.toString());
        assertNotNull(jobList);

    }

    @Test
    public void testPageQueryJobListByCity() throws Exception {
        List<CareerJob> jobList = careerDao.pageQueryJobListByCity("0755", 0, 10);
        System.out.println(jobList.toString());
        assertNotNull(jobList);

    }

    @Test
    public void testGetCompanyDetailByID() throws Exception {
        CareerCompany company = careerDao.getCompanyDetailByID(100001);
        System.out.println(company.toString());
        assertNotNull(company);
    }

    @Test
    public void testGetJobDetailByID() throws Exception {
        CareerJob job = careerDao.getJobDetailByID(100001);
        System.out.println(job.toString());
        assertNotNull(job);
    }

    @Test
    public void testPageQueryCompanyList() throws Exception {
        List<CareerCompany> companyList = careerDao.pageQueryCompanyList(0, 2);
        assertNotNull(companyList);
        System.out.println(companyList);
    }

    @Test
    public void testSearchJobList() throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", 0);
        params.put("limit", 12);
        params.put("cityCode", "0755");
        params.put("searchLine", "mes");

        List<CareerJob> jobList = careerDao.searchJobListByCondition(params);
        assertNotNull(jobList);
        System.out.println("结果集" + jobList);
    }

    @Test
    public void testSearchCompanyList() throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", 0);
        params.put("limit", 12);
        params.put("companyType", 3);

        List<CareerCompany> companyList = careerDao.searchCompanyListByName(params);
        assertNotNull(companyList);
        System.out.println("结果集" + companyList);
    }


}