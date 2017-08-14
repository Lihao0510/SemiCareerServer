package com.lihao.controller;

import com.lihao.entity.SysAuth;
import com.lihao.entity.SysRole;
import com.lihao.entity.SysUser;
import com.lihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Lihao on 2017/6/2.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;


    @RequestMapping("/allauth")
    @ResponseBody
    public List<SysAuth> getAllSysAuth(){

        List<SysAuth> authList  = userService.getAllSysAuth();
        return authList;
    }

    @RequestMapping("/allrole")
    @ResponseBody
    public List<SysRole> getAllSysRole(){

        List<SysRole> roleList  = userService.getAllSysRole();
        return roleList;
    }
}
