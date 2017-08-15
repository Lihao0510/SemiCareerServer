package com.lihao.service;

import com.lihao.dao.CareerDao;
import com.lihao.entity.CareerJob;
import com.lihao.entity.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lihao on 2017/8/15.
 */
@Service
public class CareerService {

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
        if (jobList != null && jobList.size() > 0) {
            result.setStatus(1);
            result.setResult(jobList);
        } else {
            result.setStatus(0);
            result.setErrorMsg("没有更多的职位了!");
        }
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

}
