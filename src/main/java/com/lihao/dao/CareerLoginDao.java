package com.lihao.dao;

import com.lihao.entity.CareerLoginMessage;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by lihao on 2017/8/18.
 */
@Repository
public interface CareerLoginDao {

    CareerLoginMessage loginByCondition(Map<String, Object> params);



}
