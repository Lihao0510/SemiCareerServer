package com.lihao.service;

import com.lihao.dao.NewsDao;
import com.lihao.entity.CareerNews;
import com.lihao.entity.ResponseObject;
import com.lihao.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihao on 2017/8/18.
 */
@Service
public class NewsService {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    NewsDao newsDao;


    /**
     * Gets news list by condition.
     *
     * @param params the params
     *               必选属性: pageNum(int), pageSize(int)
     *               可选属性: newsType(int), newsTag(int), newsAuthor(String)
     * @return the news list by condition
     * @Author Lihao 20170818
     */
    public ResponseObject queryNewsByCondition(Map<String, Object> params) {
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        int pageNum = Integer.parseInt((String) params.get("pageNum"));
        int pageSize = Integer.parseInt((String) params.get("pageSize"));
        queryMap.put("start", pageNum * pageSize);
        queryMap.put("limit", pageSize);

        String newsType = (String) params.get("newsType");
        String newsTag = (String) params.get("newsTag");
        String newsAuthor = (String) params.get("newsAuthor");
        if (newsType != null && !newsType.equals("")) {
            queryMap.put("newsType", newsType);
        }
        if (newsTag != null && !newsTag.equals("")) {
            queryMap.put("newsTag", newsTag);
        }
        if (newsAuthor != null && !newsAuthor.equals("")) {
            queryMap.put("newsAuthor", newsAuthor);
        }
        logger.info("查询的参数:" + queryMap.toString());

        ResponseObject result = new ResponseObject();
        List<CareerNews> newsList = null;

        try {
            newsList = newsDao.queryNewsByCondition(queryMap);
        } catch (DataAccessException e) {
            ResponseUtil.returnError(result);
        }
        ResponseUtil.returnList(newsList, result, "没有更多新闻!");
        return result;
    }

    /**
     * Add comment by news id observable.
     *
     * @param params the params
     *               必选: newsID(int), userID(int), commentText(String)
     * @return the Status
     */
    public ResponseObject addCommentByNewsID(Map<String, Object> params) {
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        ResponseObject result = new ResponseObject();

        int newsID = Integer.parseInt((String) params.get("pageNum"));
        int userID = Integer.parseInt((String) params.get("pageSize"));
        String commentText = (String) params.get("commentText");
        if (commentText == null || commentText.equals("") || newsID <= 100000 || userID < 10000) {
            ResponseUtil.returnError(result);
        }
        queryMap.put("newsID", newsID);
        queryMap.put("userID", userID);
        queryMap.put("commentText", commentText);

        int insertResult = newsDao.addCommentByNewsID(queryMap);
        ResponseUtil.returnInsertResult(insertResult, result);

        return result;
    }

    /**
     * Gets news detail by id.
     *
     * @param newsID the news id
     * @return the news detail by id
     * @Author Lihao 20170818
     */
    public ResponseObject getNewsDetailByID(int newsID) {
        ResponseObject result = new ResponseObject();

        if (newsID <= 100000){
            ResponseUtil.returnError(result);
        }

        CareerNews news = newsDao.getNewsByID(newsID);

        ResponseUtil.returnObject(news, result, "该新闻不存在!");

        return result;
    }


}
