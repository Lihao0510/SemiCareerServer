package com.lihao.entity;

/**
 * Created by Lihao on 2017/6/2.
 */
public class SysRole {

    public int roleID;
    public String roleName;
    public int roleType;

    public SysRole() {
    }

    public SysRole(String roleName, int roleType) {
        this.roleName = roleName;
        this.roleType = roleType;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", roleType=" + roleType +
                '}';
    }
}
