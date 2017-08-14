package com.lihao.dao;

import com.lihao.entity.SysAuth;
import com.lihao.entity.SysRole;
import com.lihao.entity.SysUser;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihao on 2017/3/5.
 */

@Repository
public interface UserDao {

    List<SysUser> getAll() throws DataAccessException;

    SysUser getUserByPhone(String userPhone) throws DataAccessException;

    int createUser(SysUser sysUser) throws DataAccessException;

    int updateUser(SysUser sysUser) throws DataAccessException;

    int deleteUser(int userID) throws DataAccessException;

    int addRoleToUser(int UserID, int RoleID) throws DataAccessException;

    List<SysRole> getUserRoles(int UserID) throws DataAccessException;

    int removeRoleFromUser(int UserID, int RoleID) throws DataAccessException;

    int removeAllRolesFromUser(int UserID) throws DataAccessException;

    List<SysAuth> getAllAuthByUserID(int UserID) throws DataAccessException;

}
