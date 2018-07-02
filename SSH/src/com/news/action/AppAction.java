package com.news.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.news.entity.Item;
import com.news.entity.News;
import com.news.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class AppAction extends ActionSupport {
	private static final long serialVersionUID = -860166956891026333L;
private static Logger logger=Logger.getLogger("NewsAction");
	
	@Autowired
	private NewsService newsService;
	private List<News> newslist;
	private News news;
	private Integer newsId;
	private List<Item> itemlist;
	private Item item;
	private Integer itemId;
	public String qianduan1() {
		newslist=newsService.queryNews();
		return "qianduan1";
	}
	public String qianduan2(){
		news=newsService.queryByNewsId(newsId);
		return"qianduan2";
	}
	public List<News> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public List<Item> getItemlist() {
		return itemlist;
	}
	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
}
