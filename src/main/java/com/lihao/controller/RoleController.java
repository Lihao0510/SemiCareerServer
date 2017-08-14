package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.entity.SysRole;
import com.lihao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lihao on 2017/6/11.
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    public ResponseObject createRole(@RequestBody SysRole sysRole){
        ResponseObject response = roleService.createRole(sysRole);
        return response;
    }
}
