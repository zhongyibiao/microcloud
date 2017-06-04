package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4794552714576803250L;

	private String id;

	private String account;

	private String password;

	private String name;

	private String delflag;

	private Date createddate;

	private String createby;

	private Date lastupdateddate;

	private String lastupdateddateby;

	private List<Role> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}