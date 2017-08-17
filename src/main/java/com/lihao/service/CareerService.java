package com.lihao.service;

import com.lihao.dao.CareerDao;
import com.lihao.entity.CareerCompany;
import com.lihao.entity.CareerJob;
import com.lihao.entity.ResponseObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihao on 2017/8/15.
 */
@Service
public class CareerService {

    Logger logger = Logger.getLogger(CareerService.class);

    @Autowired
    CareerDao careerDao;

    public ResponseObject pageQueryJobList(int pageNum, int pageSize) {
        ResponseObject result = new ResponseObject();
        List<CareerJob> jobList = null;
        if (pageNum < 0 && pageSize <= 0) {
            result.setStatus(4);
            result.setErrorMsg("参数错误!");
            return result;
        }
        try {
            jobList = careerDao.pageQueryJobList(pageNum * pageSize, pageSize);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        returnList(jobList, result, "没有更多的职位了");
        return result;
    }

    public ResponseObject getJobDetailByID(int jobID) {
        ResponseObject result = new ResponseObject();
        if (jobID <= 100000) {
            result.setStatus(4);
            result.setErrorMsg("参数错误!");
            return result;
        }
        CareerJob job = null;
        try {
            job = careerDao.getJobDetailByID(jobID);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        if (job != null && job.jobID == jobID) {
            result.setStatus(1);
            result.setResult(job);
        } else {
            result.setStatus(0);
            result.setErrorMsg("该职位不存在!");
        }
        return result;
    }

    public ResponseObject pageQueryCompanyList(int pageNum, int pageSize) {
        ResponseObject result = new ResponseObject();
        List<CareerCompany> companyList = null;
        if (pageNum < 0 && pageSize <= 0) {
            result.setStatus(4);
            result.setErrorMsg("参数错误!");
            return result;
        }
        try {
            companyList = careerDao.pageQueryCompanyList(pageNum * pageSize, pageSize);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        if (companyList != null && companyList.size() > 0) {
            result.setStatus(1);
            result.setResult(companyList);
        } else {
            result.setStatus(0);
            result.setErrorMsg("没有更多的公司了!");
        }
        return result;
    }

    public ResponseObject getCompanyDetailByID(int companyID) {
        ResponseObject result = new ResponseObject();
        if (companyID <= 100000) {
            result.setStatus(4);
            result.setErrorMsg("参数错误!");
            return result;
        }
        CareerCompany company = null;
        try {
            company = careerDao.getCompanyDetailByID(companyID);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        if (company != null && company.companyID == companyID) {
            result.setStatus(1);
            result.setResult(company);
        } else {
            result.setStatus(0);
            result.setErrorMsg("该公司不存在!");
        }
        return result;
    }

    public ResponseObject queryJobListByCompanyID(int companyID) {
        ResponseObject result = new ResponseObject();
        List<CareerJob> jobList = null;
        if (companyID <= 100000) {
            result.setStatus(4);
            result.setErrorMsg("参数错误!");
            return result;
        }
        try {
            jobList = careerDao.getJobListByCompanyID(companyID);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        if (jobList != null && jobList.size() > 0) {
            result.setStatus(1);
            result.setResult(jobList);
        } else {
            result.setStatus(0);
            result.setErrorMsg("该公司没有发布职位!");
        }
        return result;
    }

    public ResponseObject searchJobListByCondition(Map<String, Object> params) {
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        int pageNum = Integer.parseInt((String) params.get("pageNum"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        queryMap.put("start", pageNum * pageSize);
        queryMap.put("limit", pageSize);

        String searchLine = (String) params.get("searchLine");
        String cityCode = (String) params.get("cityCode");
        if (searchLine != null && !searchLine.equals("")) {
            queryMap.put("searchLine", searchLine);
        }
        if (cityCode != null && !cityCode.equals("")) {
            queryMap.put("cityCode", cityCode);
        }
        ResponseObject result = new ResponseObject();
        List<CareerJob> jobList = null;
        try {
            jobList = careerDao.searchJobListByCondition(queryMap);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        returnList(jobList, result, "没有更多的职位了!");
        return result;
    }

    public ResponseObject searchCompanyByCondition(Map<String, Object> params) {

        logger.info("收到的参数:" + params.toString());
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        int pageNum = Integer.parseInt((String) params.get("pageNum"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        queryMap.put("start", pageNum * pageSize);
        queryMap.put("limit", pageSize);

        String companyTag = (String) params.get("companyTag");
        String companyType = (String) params.get("companyType");
        if (companyTag != null && !companyTag.equals("")) {
            queryMap.put("companyTag", companyTag);
        }
        if (companyType != null && !companyType.equals("")) {
            queryMap.put("companyType", companyType);
        }

        String searchLine = (String) params.get("searchLine");
        String companyCity = (String) params.get("companyCity");
        if (searchLine != null && !searchLine.equals("")) {
            queryMap.put("searchLine", searchLine);
        }
        if (companyCity != null && !companyCity.equals("")) {
            queryMap.put("companyCity", companyCity);
        }
        logger.info("查询的参数:" + queryMap.toString());

        ResponseObject result = new ResponseObject();
        List<CareerCompany> companyList = null;
        try {
            companyList = careerDao.searchCompanyListByName(queryMap);
        } catch (DataAccessException e) {
            result.setStatus(4);
            result.setErrorMsg("发生错误!");
        }
        returnList(companyList, result, "没有更多的公司了!");
        return result;
    }

    private <T> void returnList(List<T> list, ResponseObject result, String error) {
        if (list != null && list.size() > 0) {
            result.setStatus(1);
            result.setResult(list);
        } else {
            result.setStatus(0);
            result.setErrorMsg("没有更多的职位了!");
        }
    }

}
