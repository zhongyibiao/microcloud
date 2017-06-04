package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.util.Date;

public class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1338299156545929990L;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private String delFlag;

	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
