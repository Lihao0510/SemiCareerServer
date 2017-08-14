package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lihao on 2017/8/13.
 */
@Controller
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @RequestMapping(value = "/getbysender", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getMailListBySender(){
        return mailService.getMailList();
    }

}
