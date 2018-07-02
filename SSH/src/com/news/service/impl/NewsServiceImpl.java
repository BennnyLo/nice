package com.news.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.item.dao.ItemDao;
import com.news.dao.NewsDao;
import com.news.entity.Item;
import com.news.entity.News;
import com.news.entity.Users;
import com.news.service.NewsService;
import com.users.dao.UsersDao;


@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UsersDao usersdao;
	/*
	 * news表增删改查
	 * */
	@Override
	@Transactional(readOnly=true)
	public List<News> queryNews() {
		List<News> aList = newsDao.queryNews();
		return aList;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Integer addNews(News news ,File upload ,String uploadContentType ,String uploadFileName) throws IOException{
		return newsDao.addNews(news, upload, uploadContentType, uploadFileName);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void deleteNews(Integer news) {
		newsDao.deleteNews(news);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public News queryByNewsId(Integer newsId) {
		return newsDao.queryByNewsId(newsId);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateNews(News news) {
		newsDao.updateNews(news);
	}
	@Override
	public List<Item> queryItem() {
		return newsDao.queryItem();
	}
	public List<News> fuzzyqueryNews(String character){
		return newsDao.fuzzyqueryNews(character);
	}
	/*分页页码*/
	@Override
	public Long count() {
		
		return newsDao.count();
	}
	public Long countItem() {
		return itemDao.countItem();
	}
	public Long countUsers(){
		return usersdao.countUsers();
	}
	@Override
	public List<News> queryByPage(Integer pageSize, Integer pageNo) {
		return  newsDao.queryByPage(pageSize, pageNo);
	}
	public List<Item> queryByPageItem(Integer pageSize, Integer pageNo) {
		return itemDao.queryByPageItem(pageSize, pageNo);
	}
	public List<Users> queryByPageUsers(Integer pageSize, Integer pageNo){
		return usersdao.queryByPageUsers(pageSize, pageNo);
	}
	/*
	 * 根据item表查询news表
	 * */
	@Override
	
	public List<News> queryByNews(News news) {
		return newsDao.queryByNews(news);
	}
	/*
	 * item表增删改查
	 * */

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Item> queryallItem() {
		return itemDao.queryallItem();
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Item> fuzzyqueryItem(String character) {
		return itemDao.fuzzyqueryItem(character);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addItem(Item item) {
		return itemDao.addItem(item);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteItem(Integer itemId) {
		itemDao.deleteItem(itemId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Item queryByItemId(Integer itemId) {
		return itemDao.queryByItemId(itemId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Users> queryallUsers() {
		return usersdao.queryallUsers();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addUsers(Users users) {
		return usersdao.addUsers(users);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteUsers(Integer userId) {
		usersdao.deleteUsers(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Users queryByUsersId(Integer userId) {
		return usersdao.queryByUsersId(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUsers(Users users) {
		usersdao.updateUsers(users);
	}

//	public Users queryUsersName(String name) {
//		return usersdao.queryUsersName(name);
//	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Users> queryUsersName(String name ,String pwd) {
		return usersdao.queryUsersName(name, pwd);
	}

	@Override
	public List<Users> fuzzyqueryUsers(String character) {
		return usersdao.fuzzyqueryUsers(character);
	}

	
}
	