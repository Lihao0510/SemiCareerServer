package com.lihao.service;

import com.lihao.dao.RoleDao;
import com.lihao.dao.UserDao;
import com.lihao.entity.ResponseObject;
import com.lihao.entity.SysRole;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lihao on 2017/6/10.
 */
@Service
public class RoleService {

    Logger logger = Logger.getLogger(RoleService.class);

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    public ResponseObject getUserRolesByID(int userID) {
        ResponseObject response = new ResponseObject();
        try {
            List<SysRole> roleList = userDao.getUserRoles(userID);
            if (roleList == null || roleList.size() == 0) {
                response.setResult(0);
                response.setResult("该用户暂无角色!");
            } else {
                response.setResult(1);
                response.setResult(roleList);
            }
        } catch (DataAccessException e) {
            response.setResult(4);
            response.setResult("参数错误");
        }
        return response;
    }

    public ResponseObject createRole(SysRole sysRole) {
        ResponseObject response = new ResponseObject();
        try {
            int addResult = roleDao.createRole(sysRole);
            if (addResult == 1) {
                System.out.println("插入后的角色ID:" + sysRole.getRoleID());
                response.setStatus(1);
                response.setResult(sysRole.getRoleID());
            } else {
                response.setStatus(0);
                response.setResult("角色已存在!");
            }
        } catch (DataAccessException e) {
            response.setStatus(4);
            response.setResult("参数错误!");
        }
        return response;
    }

    public ResponseObject addRoleToUser(int userID, int roleID) {
        ResponseObject response = new ResponseObject();
        try {
            int addResult = userDao.addRoleToUser(userID, roleID);
            if(addResult == 1){
                response.setStatus(1);
                response.setResult("绑定成功!");
            }else{
                response.setStatus(0);
                response.setResult("角色不存在!");
            }
        } catch (DataAccessException e) {
            response.setStatus(4);
            response.setResult("参数错误!");
        }
        return response;
    }

    public ResponseObject removeRoleFromUser(int userID, int roleID) {
        ResponseObject response = new ResponseObject();
        try {
            int removeResult = userDao.removeRoleFromUser(userID, roleID);
            if(removeResult == 1){
                response.setStatus(1);
                response.setResult("解绑成功!");
            }else{
                response.setStatus(0);
                response.setResult("角色不存在!");
            }
        } catch (DataAccessException e) {
            response.setStatus(4);
            response.setResult("参数错误!");
        }
        return response;
    }

}
