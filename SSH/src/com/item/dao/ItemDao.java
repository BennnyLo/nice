package com.item.dao;

import java.util.List;

import com.news.entity.Item;
import com.news.entity.News;

public interface ItemDao {
	public List<Item> queryallItem();
	public Integer addItem(Item item);
	public void deleteItem(Integer itemId);
	public Item queryByItemId(Integer itemId);
	public void updateItem(Item item);
	public List<Item> queryByPageItem(Integer pageSize,Integer pageNo );
	public Long countItem();
	List<Item> fuzzyqueryItem(String character);
}
