package com.neaghfoz.component.user.user.model;

import com.neaghfoz.component.user.role.model.Role;

import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 上午9:17
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userId; //用户ID
    private String userName; //登录的用户名
    private Integer sex; //性别
    private String nickName; //昵称
    private String phone; //电话号码
    private String email; //邮箱
    private Integer status; //用户状态
    private Date createTime; //创建时间
    private Set<Role>  roles;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {

        return userId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
