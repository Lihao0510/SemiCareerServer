package com.lihao.controller;

import com.lihao.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lihao on 2017/3/8.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/getname")
    @ResponseBody
    public SysUser getUserName() {
        final SysUser user = new SysUser();
        redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize("redisname");
                if(redisConnection.exists(key)){
                    byte[] value = redisConnection.get(key);
                    String result = (String) redisTemplate.getStringSerializer().deserialize(value);
                    System.out.println(result);
                    user.setUserName(result);
                    user.setUserId(10001);
                    user.setUserEmail("591353643@qq.com");
                    return user;
                }
                return user;
            }
        });
        return user;
    }

    @RequestMapping("/setname")
    public void setUserName() {
        redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set(redisTemplate.getStringSerializer().serialize("redisname"),
                        redisTemplate.getStringSerializer().serialize("wangnimalolol"));
                return null;
            }
        });
    }

    @RequestMapping(value = "/teststring", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String teststring() {
        return "大家好:5563qqui";
    }
}
