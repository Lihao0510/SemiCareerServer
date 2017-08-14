package com.lihao.dao;

import com.lihao.entity.CareerJob;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihao on 2017/8/14.
 */
@Repository
public interface CareerDao {

    List<CareerJob> pageQueryJobList(int pageNum);

    CareerJob getJobDetailByID(int jobID);

    List<CareerJob> getJobListByCompanyID(int companyID);

}
