package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lihao on 2017/8/8.
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getNoticeList() {
        return noticeService.getAllNotice();
    }

}
