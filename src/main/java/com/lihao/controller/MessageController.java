package com.lihao.controller;

import com.lihao.entity.CareerMessage;
import com.lihao.entity.ResponseObject;
import com.lihao.service.MessageService;
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
@RequestMapping("/message")
public class MessageController {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject queryMessageByCondition(@RequestParam Map<String, Object> params) {
        logger.info(params);
        return messageService.queryMessageByCondition(params);
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject writeMessage(@RequestParam CareerMessage message) {
        logger.info(message);
        return messageService.writeMessage(message);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getMessageDetailByID(@RequestParam("messageID") int messageID) {
        logger.info(messageID);
        return messageService.getMessageDetailByID(messageID);
    }

    @RequestMapping(value = "/changestatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject changeMessageStatus(
            @RequestParam("messageID") int messageID,
            @RequestParam("messageTag") int messageTag) {
        logger.info("messageID:" + messageID + "; messageTag:" + messageTag);
        return messageService.setMessageStatusByID(messageID, messageTag);
    }

    @RequestMapping(value = "/getnum", method = RequestMethod.POST)
    @ResponseBody
    public ResponseObject getMessageNumByTag(
            @RequestParam("messageID") int messageID,
            @RequestParam("messageTag") int messageTag) {
        logger.info("messageID:" + messageID + "; messageTag:" + messageTag);
        return messageService.setMessageStatusByID(messageID, messageTag);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject deleteMessageByID(@RequestParam("messageID") int messageID) {
        logger.info(messageID);
        return messageService.deleteMessageByID(messageID);
    }

}
