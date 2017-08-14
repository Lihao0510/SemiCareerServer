package com.lihao.entity;

/**
 * Created by Lihao on 2017/6/2.
 */
public class SysAuth {

    public int authID;
    public String authName;
    public int authType;

    public SysAuth(){}

    public SysAuth(String authName, int authType){
        this.authName = authName;
        this.authType = authType;
    }

    public int getAuthID() {
        return authID;
    }

    public void setAuthID(int authID) {
        this.authID = authID;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public int getAuthType() {
        return authType;
    }

    public void setAuthType(int authType) {
        this.authType = authType;
    }

    @Override
    public String  toString() {
        return "SysAuth{" +
                "authID=" + authID +
                ", authName='" + authName + '\'' +
                ", authType=" + authType +
                '}';
    }
}
