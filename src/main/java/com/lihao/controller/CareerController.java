package com.lihao.controller;

import com.lihao.entity.ResponseObject;
import com.lihao.service.CareerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lihao on 2017/8/15.
 */
@Controller
@RequestMapping(value = "/career")
public class CareerController {

    Logger logger = Logger.getLogger(CareerController.class);

    @Autowired
    CareerService careerService;

    @RequestMapping(value = "/queryjoblist", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject pageQueryJobList(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize) {
        return careerService.pageQueryJobList(pageNum, pageSize);
    }

    @RequestMapping(value = "/querycompanylist", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject pageQueryCompanyList(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize) {
        return careerService.pageQueryJobList(pageNum, pageSize);
    }

    @RequestMapping(value = "/getjobdetail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getJobDetailByID(@RequestParam("jobID") int jobID) {
        return careerService.getJobDetailByID(jobID);
    }

    @RequestMapping(value = "/getcompanydetail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getCompanyDetailByID(@RequestParam("companyID") int jobID) {
        return careerService.getJobDetailByID(jobID);
    }

    @RequestMapping(value = "/searchjoblist", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject searchJobByCondition(@RequestParam Map<String, Object> params) {
        return careerService.searchJobListByCondition(params);
    }

    @RequestMapping(value = "/querycompany", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject searchCompanyByCondition(@RequestParam Map<String, Object> params) {
        return careerService.searchCompanyByCondition(params);
    }

}
