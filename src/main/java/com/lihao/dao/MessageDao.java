package com.lihao.dao;

import com.lihao.entity.CareerMessage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lihao on 2017/8/17.
 */
@Repository
public interface MessageDao {

    List<CareerMessage> queryMessageByCondition(Map<String, Object> params);

    int writeMessage(CareerMessage message);

    int deleteMessageByID(int messageID);

}
