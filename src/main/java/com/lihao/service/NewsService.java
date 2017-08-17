package com.lihao.service;

import com.lihao.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lihao on 2017/8/18.
 */
@Service
public class NewsService {

    @Autowired
    NewsDao newsDao;


}
