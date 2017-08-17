package com.lihao.dao;

import com.lihao.entity.CareerCompany;
import com.lihao.entity.CareerJob;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /*
    * @param searchMap需要包含的参数为:
    * start: 开始行数
    * limit: 返回的最大行数
    * cityCode: (可选)城市编码
    * searchLine: (可选)查询字符串
    * */
    List<CareerJob> searchJobListByCondition(Map<String, Object> searchMap);


    /*
    * @param searchMap需要包含的参数为:
    * start: 开始行数
    * limit: 返回的最大行数
    * copanyCity: (可选)城市编码
    * searchLine: (可选)查询字符串
    * companyType: (可选)公司类型
    * companyTag: (可选)公司行业
    * */
    List<CareerCompany> searchCompanyListByName(Map<String, Object> searchMap);

}
