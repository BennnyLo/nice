package com.news.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable {
	private static final long serialVersionUID = -8372857046980831570L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer itemId;
	@Column(name="name")
	public String name;
	public Item() {
		super();
	}
	public Item(Integer itemId, String name) {
		super();
		this.itemId = itemId;
		this.name = name;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
