package com.news.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class Users implements Serializable {
	private static final long serialVersionUID = 4241423255246096567L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;//Ö÷¼ü.
	@Column(name="name")
	private String name;
	@Column(name="pwd")
	private String pwd;//
	@Column(name="createTime")
	private Date createTime;//
	@Column(name="updateTime")
	private Date updateTime;//
	
	public Users(Integer userId, String name, String pwd, Date createTime, Date updateTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.pwd = pwd;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Users() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
