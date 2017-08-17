package com.lihao.controller;

import com.lihao.entity.ResponseObject;
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
@RequestMapping("/news")
public class NewsController {

    @RequestMapping(value = "/querybycondition", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject queryNewsByCondition(@RequestParam Map<String, Object> params) {

        return null;
    }

    @RequestMapping(value = "/addCommentByNewsID", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject addCommentByNewsID(@RequestParam Map<String, Object> params) {

        return null;
    }

    @RequestMapping(value = "/getdetail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject addCommentByNewsID(@RequestParam("newsID") int newsID) {

        return null;
    }

}
