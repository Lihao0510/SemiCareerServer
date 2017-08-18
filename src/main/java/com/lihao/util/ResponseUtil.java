package com.lihao.util;

import com.lihao.entity.ResponseObject;

import java.util.List;

/**
 * Created by lihao on 2017/8/18.
 */
public class ResponseUtil {

    public static <T> void returnList(List<T> list, ResponseObject result, String error) {
        if (list != null && list.size() > 0) {
            result.setStatus(1);
            result.setResult(list);
        } else {
            result.setStatus(0);
            result.setErrorMsg(error);
        }
    }

    public static void returnObject(Object obj, ResponseObject result, String error) {
        if (obj != null) {
            result.setStatus(1);
            result.setResult(obj);
        } else {
            result.setStatus(0);
            result.setErrorMsg(error);
        }
    }

    public static void returnError(ResponseObject result) {
        result.setStatus(4);
        result.setErrorMsg("数据参数错误!");
    }

    public static void returnInsertResult(int resultCode, ResponseObject result) {
        if (resultCode == 0) {
            result.setStatus(0);
            result.setErrorMsg("数据插入失败");
        } else {
            result.setStatus(1);
        }
    }
}
