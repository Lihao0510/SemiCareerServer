package com.lihao.service;

import com.lihao.dao.AuthDao;
import com.lihao.entity.ResponseObject;
import com.lihao.entity.SysAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * Created by Lihao on 2017/6/11.
 */
@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;

    public ResponseObject createAuth(SysAuth sysAuth){
        ResponseObject response = new ResponseObject();
        try{
            int addResult = authDao.createAuth(sysAuth);
            if(addResult == 1){
                response.setStatus(1);
                response.setResult(sysAuth.authID);
            }else{
                response.setStatus(0);
                response.setResult("该权限已存在!");
            }
        }catch (DataAccessException e){
            response.setStatus(4);
            response.setResult("参数错误");
        }
        return response;
    }
}
