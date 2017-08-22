package com.lihao.service;

import com.lihao.entity.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lihao on 2017/8/19.
 */
@Component
public class LoginServiceTest {

    @Autowired
    LoginService loginService;

    public Object testLoginByPhone(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userPhone", "17786123214");
        params.put("userPwd", "55637179q");
        return loginService.careerLoginByPhone(params).getResult();
    }

}