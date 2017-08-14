package com.lihao.service;

import com.lihao.dao.AuthDao;
import com.lihao.dao.RoleDao;
import com.lihao.dao.UserDao;
import com.lihao.entity.ResponseObject;
import com.lihao.entity.SysAuth;
import com.lihao.entity.SysRole;
import com.lihao.entity.SysUser;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihao on 2017/3/5.
 */

@Service
public class UserService {

    static Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthDao authDao;

    @Autowired
    private RoleDao roleDao;

    public ResponseObject getAllSysUser() {
        ResponseObject response = new ResponseObject();
        List<SysUser> userList;
        try {
            userList = userDao.getAll();
            if (userList == null || userList.size() == 0) {
                response.setStatus(0);
                response.setErrorMsg("用户不存在!");
                return response;
            }
        } catch (DataAccessException e) {
            response.setStatus(4);
            response.setErrorMsg("访问错误!");
            return response;
        }
        response.setStatus(1);
        response.setResult(userList);
        return response;
    }

    public List<SysRole> getAllSysRole() {
        return roleDao.getAll();
    }

    public List<SysAuth> getAllSysAuth() {
        return authDao.getAll();
    }

    /*
    测试EHcache代码
    @Cacheable(value = "baseCache")
    public SysUser testCache() {
        SysUser user = new SysUser();
        user.setUserId(10005);
        user.setUserName("王尼玛");
        user.setUserDesc("大家好，我是王尼玛！");
        user.setUserEmail("wangnima@163.com");
        user.setUserPwd("123456");
        System.out.println("从数据库获取：" + user.toString());
        return user;
    }*/

    //系统管理员登录用接口,登陆成功返回用户信息
    public ResponseObject loginByPhone(String userPhone, String userPwd) {
        ResponseObject response = new ResponseObject();
        SysUser loginUser = userDao.getUserByPhone(userPhone);
        String shaPwd = userPwd;//DigestUtils.sha1Hex(userPwd);
        if (loginUser == null) {
            response.setStatus(0);
            response.setErrorMsg("用户不存在!");
            return response;
        }
        if (!shaPwd.equals(loginUser.getUserPwd())) {
            response.setStatus(4);
            response.setErrorMsg("密码错误!");
            return response;
        }
        response.setStatus(1);
        response.setResult(loginUser);
        return response;
    }

    //添加新用户,目前只支持超级管理员添加
    public ResponseObject addNewSysUser(SysUser user) {
        ResponseObject response = new ResponseObject();
        try {
            int addResult = userDao.createUser(user);
            if (addResult == 1) {
                System.out.println("插入后的用户ID:" + user.getUserId());
                response.setStatus(1);
                response.setResult(user.getUserId());
            } else {
                response.setStatus(0);
                response.setResult("用户已存在!");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            response.setStatus(4);
            response.setResult("参数错误!");
        }
        return response;
    }

    public ResponseObject deleteSysUser(int userID) {
        ResponseObject response = new ResponseObject();
        try {
            int deleteResult = userDao.deleteUser(userID);
            if (deleteResult == 1) {
                response.setStatus(1);
                response.setResult("删除成功!");
            } else {
                response.setStatus(0);
                response.setResult("删除失败!");
            }
        } catch (DataAccessException e) {
            response.setStatus(4);
            response.setResult("参数错误!");
        }
        return response;
    }

    //修改用户信息的方法,可用于修改用户密码和其他相关资料
    public ResponseObject modifySysUser(SysUser user) {
        ResponseObject response = new ResponseObject();
        try {
            int updateResult = userDao.updateUser(user);
            if (updateResult == 1) {
                response.setStatus(1);
                response.setResult(user);
            } else {
                response.setStatus(0);
                response.setResult("用户不存在!");
            }
        } catch (DataAccessException e) {
            response.setStatus(4);
            response.setResult("参数错误!");
        }
        return response;
    }

}
