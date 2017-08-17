package com.lihao.dao;

import com.lihao.entity.CareerResume;
import org.springframework.stereotype.Repository;

/**
 * Created by lihao on 2017/8/17.
 */
@Repository
public interface ResumeDao {

    CareerResume getResumeByUserID(int userID);

    int createResume(CareerResume resume);

    int updateResume(CareerResume resume);

    int deleteResume(int resumeID);
}
