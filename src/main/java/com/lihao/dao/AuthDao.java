package com.lihao.dao;

import com.lihao.entity.SysAuth;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lihao on 2017/6/2.
 */
@Repository
public interface AuthDao {

    List<SysAuth> getAll();

    int createAuth(SysAuth auth) throws DataAccessException;

    int deleteAuth(int authID) throws DataAccessException;

}
