package com.lihao.service;

import com.lihao.dao.CareerLoginDao;
import com.lihao.dao.UserDao;
import com.lihao.entity.CareerLoginMessage;
import com.lihao.entity.ResponseObject;
import com.lihao.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lihao on 2017/8/18.
 */
@Service
public class LoginService {

    @Autowired
    CareerLoginDao careerLoginDao;

    @Autowired
    UserDao userDao;

    public ResponseObject careerLoginByPhone(Map<String, Object> params) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        ResponseObject result = new ResponseObject();
        String userPhone = (String) params.get("userPhone");
        String userPwd = (String) params.get("userPwd");
        if (userPhone != null && userPhone.length() >= 10) {
            queryMap.put("userPhone", userPhone);
        } else {
            ResponseUtil.returnError(result);
        }
        if (userPwd != null && !userPwd.equals("")) {
            queryMap.put("userPwd", userPwd);
        } else {
            ResponseUtil.returnError(result);
        }
        CareerLoginMessage loginResult = null;
        try {
            loginResult = careerLoginDao.loginByCondition(queryMap);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnObject(loginResult, result, "用户名或密码错误!");
        return result;
    }

}
