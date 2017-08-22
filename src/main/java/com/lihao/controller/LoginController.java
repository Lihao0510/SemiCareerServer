package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.entity.SysUser;
import com.lihao.service.LoginService;
import com.lihao.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by lihao on 2017/8/18.
 */
@Controller
@RequestMapping("/launch")
public class LoginController {

    Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/oalogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject oaLoginByPhone(@RequestParam Map<String, Object> params) {

        return null;
    }

    @RequestMapping(value = "/careerlogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject careerLoginByPhone(@RequestParam Map<String, Object> params) {
        logger.info(params);
        return loginService.careerLoginByPhone(params);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject registerByPhone(@RequestParam SysUser param) {


        return null;
    }

    @RequestMapping(value = "/changepwd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject changePwdByID(@RequestParam Map<String, Object> params) {


        return null;
    }

}
