package com.lihao.dao;

import com.lihao.entity.SysAuth;
import com.lihao.entity.SysRole;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lihao on 2017/6/2.
 */
@Repository
public interface RoleDao {

    List<SysRole> getAll() throws DataAccessException;

    List<SysAuth> getAuthByRoleID(int roleID) throws DataAccessException;

    int createRole(SysRole sysRole) throws DataAccessException;

    int deleteRole(int roleID) throws DataAccessException;

    int addAuthToRole(int roleID, int authID) throws DataAccessException;

    int removeAuthFromRole(int roleID, int authID) throws DataAccessException;

    int clearAuthFromRole(int roleID) throws DataAccessException;

}
