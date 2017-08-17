package com.lihao.dao;

import com.lihao.entity.CareerNews;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lihao on 2017/8/17.
 */
@Repository
public interface NewsDao {

    List<CareerNews> queryNewsByCondition(Map<String, Object> params);

    CareerNews getNewsByID(int newsID);

    int addCommentByNewsID(Map<String, Object> params);


}
