package com.news.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.news.entity.Item;
import com.news.entity.News;

public interface NewsDao{
	/*
	 * news表增删改查
	 * */
	public List<News> queryNews();
	public Integer addNews(News news ,File upload ,String uploadContentType ,String uploadFileName) throws IOException;
	public void deleteNews(Integer news);
	public News queryByNewsId(Integer newsId);
	public void updateNews(News news);
	
	/*
	 * 页码
	 * */
	public Long count();
	public List<News> queryByPage(Integer pageSize, Integer pageNo);
	/*
	 * 根据item表查询news表
	 * */
	public List<News> queryByNews(News news);
	
	
	/*
	 * item表增删改查
	 * */
	public List<Item> queryItem();
	public List<News> fuzzyqueryNews(String character);
}
