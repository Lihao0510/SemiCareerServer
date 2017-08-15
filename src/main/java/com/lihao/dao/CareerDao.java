package com.lihao.dao;

import com.lihao.entity.CareerCompany;
import com.lihao.entity.CareerJob;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihao on 2017/8/14.
 * 单元测试通过
 */
@Repository
public interface CareerDao {

    List<CareerJob> pageQueryJobList(int start, int limit);

    CareerJob getJobDetailByID(int jobID);

    List<CareerJob> getJobListByCompanyID(int companyID);

    CareerCompany getCompanyDetailByID(int companyID);

    List<CareerCompany> pageQueryCompanyList(int start, int limit);

    List<CareerJob> pageQueryJobListByCity(String cityCode, int start, int limit);

}
