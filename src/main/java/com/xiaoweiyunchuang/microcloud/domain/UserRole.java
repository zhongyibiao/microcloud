package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.security.acl.Group;
import java.util.Date;

public class UserRole implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6730968143113418361L;


	private String id;


    private String userId;


    private String roleId;


    private String delflag;


    private Date createddate;


    private String createby;


    private Date lastupdateddate;


    private String lastupdateddateby;

    private User user;

    private Group group;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }


    public String getRoleId() {
        return roleId;
    }


    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }


    public String getDelflag() {
        return delflag;
    }


    public void setDelflag(String delflag) {
        this.delflag = delflag == null ? null : delflag.trim();
    }


    public Date getCreateddate() {
        return createddate;
    }


    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }


    public String getCreateby() {
        return createby;
    }


    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }


    public Date getLastupdateddate() {
        return lastupdateddate;
    }


    public void setLastupdateddate(Date lastupdateddate) {
        this.lastupdateddate = lastupdateddate;
    }


    public String getLastupdateddateby() {
        return lastupdateddateby;
    }


    public void setLastupdateddateby(String lastupdateddateby) {
        this.lastupdateddateby = lastupdateddateby == null ? null : lastupdateddateby.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}