package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Role implements Serializable{

    private String id;


    private String role;


    private String description;


    private String delflag;


    private Date createddate;


    private String createby;


    private Date lastupdateddate;


    private String lastupdateddateby;


    private List<Permission> permissions;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}