package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.entity.SysUser;
import com.lihao.service.RoleService;
import com.lihao.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lihao on 2017/3/5.
 */

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /*
    这个方法是提供给Json数据访问的,适合ReactNative
    @RequestMapping(value = "/syslogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject getAllSysUser(@RequestBody Map<String, String> params){
        String userPhone = params.get("userPhone");
        String userPwd = params.get("userPwd");
        ResponseObject response = userService.loginByPhone(userPhone, userPwd);
        return response;
    }*/

    @RequestMapping(value = "/syslogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject userLogin(@RequestParam("userPhone") String userPhone,
                                        @RequestParam("userPwd") String userPwd) {

        return userService.loginByPhone(userPhone, userPwd);

    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getAllUser(){
        return userService.getAllSysUser();
    }

    @RequestMapping(value = "/addmanager", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject addNewSysUser(@RequestBody Map<String, String> params) {

        SysUser newUser = new SysUser();
        newUser.userPhone = params.get("userPhone");
        newUser.userPwd = DigestUtils.sha1Hex(params.get("userPwd"));
        newUser.userName = params.get("userName");
        newUser.userEmail = params.get("userEmail");
        newUser.userDesc = params.get("userDesc");
        ResponseObject response = userService.addNewSysUser(newUser);
        return response;
    }

    @RequestMapping(value = "/updatemanager", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject modifySysUser(@RequestBody Map<String, String> params) {
        SysUser newUser = new SysUser();
        newUser.userId = Integer.parseInt(params.get("userId"));
        newUser.userPhone = params.get("userPhone");
        newUser.userPwd = DigestUtils.sha1Hex(params.get("userPwd"));
        newUser.userName = params.get("userName");
        newUser.userEmail = params.get("userEmail");
        newUser.userDesc = params.get("userDesc");
        ResponseObject response = userService.addNewSysUser(newUser);
        return response;
    }

    @RequestMapping(value = "/getrole/{userID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getUserRolesByID(@PathVariable int userID) {
        ResponseObject response = roleService.getUserRolesByID(userID);
        return response;
    }

    @RequestMapping(value = "/addrole", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject addRoleToUser(@RequestBody Map<String, Integer> params) {
        int userID = params.get("userID");
        int roleID = params.get("roleID");
        ResponseObject response = roleService.addRoleToUser(userID, roleID);
        return response;
    }

    @RequestMapping(value = "/removerole", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject removeRoleFromUser(@RequestParam Map<String, Integer> params) {
        int userID = params.get("userID");
        int roleID = params.get("roleID");
        ResponseObject response = roleService.removeRoleFromUser(userID, roleID);
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject deleteUser(@RequestParam Map<String, Integer> params) {
        int userID = params.get("userID");
        ResponseObject response = userService.deleteSysUser(userID);
        return response;
    }

}
