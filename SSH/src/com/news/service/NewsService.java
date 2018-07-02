package com.news.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.news.entity.Item;
import com.news.entity.News;
import com.news.entity.Users;

public interface NewsService {
	/*
	 * news表增删改查
	 * */
	public List<News> queryNews();
	public Integer addNews(News news ,File upload ,String uploadContentType ,String uploadFileName) throws IOException;
	public void deleteNews(Integer news);
	public News queryByNewsId(Integer newsId);
	public void updateNews(News news);
	public List<Item> queryItem();
	public List<News> fuzzyqueryNews(String character);
	
	/*
	 * 页码
	 * */
	public Long count();
	public Long countItem();
	public Long countUsers();
	public List<News> queryByPage(Integer pageSize, Integer pageNo);
	public List<Item> queryByPageItem(Integer pageSize, Integer pageNo);
	public List<Users> queryByPageUsers(Integer pageSize, Integer pageNo);
	/*
	 * 根据item表查询news表
	 * */
	public List<News> queryByNews(News news);
	
	
	/*
	 * item表增删改查
	 * */
	public List<Item> queryallItem();
	public Integer addItem(Item item);
	public void deleteItem(Integer itemId);
	public Item queryByItemId(Integer itemId);
	public void updateItem(Item item);
	public List<Item> fuzzyqueryItem(String character);
	/*
	 * users表的增删改查
	 * 
	 * */
	public List<Users> queryallUsers();
	public Integer addUsers(Users users);
	public void deleteUsers(Integer userId);
	public Users queryByUsersId(Integer userId);
	public void updateUsers(Users users);
	List<Users> fuzzyqueryUsers(String character);
	/*根据name查询users表*/
	public List<Users> queryUsersName(String name ,String pwd);
//	public Users  queryUsersName(String name);
}
