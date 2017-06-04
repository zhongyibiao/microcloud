package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.util.Date;

public class RolePermission implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8571583521940586445L;


	private String id;


    private String roleId;


    private String permissionId;


    private String delflag;


    private Date createddate;


    private String createby;


    private Date lastupdateddate;


    private String lastupdateddateby;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getRoleId() {
        return roleId;
    }


    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }


    public String getPermissionId() {
        return permissionId;
    }


    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
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
}