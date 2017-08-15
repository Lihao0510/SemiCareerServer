package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lihao on 2017/8/15.
 */
@Controller
@RequestMapping(value = "/career")
public class CareerController {

    @Autowired
    CareerService careerService;

    @RequestMapping(value = "/queryjoblist", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject pageQueryJobList(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize) {
        return careerService.pageQueryJobList(pageNum, pageSize);
    }

    @RequestMapping(value = "/getjobdetail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getJobDetailByID(@RequestParam("jobID") int jobID) {
        return careerService.getJobDetailByID(jobID);
    }

}
