package com.khpc.cn.web.model.pojo;

/**
 * @author Vinne
 * @date 2020/1/19 0:41
 * @description
 **/
public class User {

    private String name;

    private String password;

    private String phoneNum;

    private String email;

    /**
     *  用户角色标志位 1.一般用户  2.填报员  3.系统管理员
     */
    private String roleId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
