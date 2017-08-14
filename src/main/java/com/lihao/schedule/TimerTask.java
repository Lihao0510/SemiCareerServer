package com.lihao.schedule;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by lihao on 2017/3/7.
 */
@Component("taskJob")
public class TimerTask {

    Logger logger = Logger.getLogger(TimerTask.class);

    public void timerTask(){
        logger.info("定时任务正在进行中");
    }
}
