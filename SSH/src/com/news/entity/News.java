package com.news.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="news")
public class News implements Serializable {
	private static final long serialVersionUID = 4804417290625748290L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer newsId;//Ö÷¼ü
//	@Column(name="itemId")
//	private Integer itemId;//Íâ¼ü
	@ManyToOne
	@JoinColumn(name="itemId")
	private Item item;
	@Column(name="title")
	private String title;//
	@Column(name="detail")
	private String detail;//
	@Column(name="imgUrl")
	private String imgUrl;//
	@Column(name="createTime")
	private Date createTime;//
	@Column(name="updateTime")
	private Date updateTime;//
	
	public News(Integer newsId, Item item, String title, String detail,
			String imgUrl, Date createTime, Date updateTime) {
		super();
		this.newsId = newsId;
		this.item = item;
		this.title = title;
		this.detail = detail;
		this.imgUrl = imgUrl;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public News() {
		super();
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
