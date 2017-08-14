package com.lihao.dao;

import com.lihao.entity.EnterpriseNotice;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihao on 2017/8/8.
 */
@Repository
public interface NoticeDao {

    List<EnterpriseNotice> getAllNotice() throws DataAccessException;

}
