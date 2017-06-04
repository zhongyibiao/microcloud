package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.util.Date;

public class Permission implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7472408476563206953L;


	private String id;


    private String name;


    private String permission;


    private String url;


    private String resourceType;


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


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getPermission() {
        return permission;
    }


    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


    public String getResourceType() {
        return resourceType;
    }


    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
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