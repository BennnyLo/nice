package com.news.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.news.entity.Item;
import com.news.entity.News;
import com.news.entity.Users;
import com.news.service.NewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport{
	private static final long serialVersionUID = -6227205078592466784L;
	private static Logger logger=Logger.getLogger("NewsAction");
	
	@Autowired
	private NewsService newsService;
	
	private List<News> newslist;
	private News news;
	private Integer newsId;
	private List<Item> itemlist;
	private Item item;
	private Integer itemId;
	private List<Users> userslist;
	private Users users;
	private Integer userId;
	private String name;
	private String pwd; 
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private Integer pageSize=10;
	private Long totalNum;
	private Long totalPage;
	private Integer pageNo;
	private int i;
	private String msg;
	private String checkcode;
	private String character;
	/*
	 * 新闻表查寻全部
	 **/
	public String querynews() {
		try {
			totalNum =	newsService.count();
			totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;
			i = totalPage.intValue();
			System.out.println("一共有"+totalNum+"条新闻，每页"+pageSize+"条记录，共"+totalPage+"页");
			if (pageNo==null) {
				pageNo=1;
			}
			newslist=newsService.queryByPage(pageSize,pageNo);
			return "querynews";
		} catch (Exception e) {
			return "error" ;
		}
	}
	/*
	 * 模糊查询，新闻检索
	 * */
	public String fuzzyquerynews() {
		newslist=newsService.fuzzyqueryNews(character);
		return "fuzzyquerynews";
	}
	/*
	 * 模糊查询，item检索
	 * */
	public String fuzzyqueryitem() {
		itemlist=newsService.fuzzyqueryItem(character);
		return "fuzzyqueryitem";
	}
	/*
	 * 模糊查询，新闻检索
	 * */
	public String fuzzyqueryusers() {
		userslist=newsService.fuzzyqueryUsers(character);
		return "fuzzyqueryusers";
	}
	/*新闻表添加
	 * */
	public String addnews() {
		news.setCreateTime(new Date());
		try {
			newsService.addNews(news, upload, uploadContentType, uploadFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "addnews";
	}
	/*
	 * 查寻item表（新闻表添加前置步骤）
	 * */
	public String queryitem() {
		itemlist=newsService.queryItem();
		return"queryitem";
	}
	/*
	 * 新闻表删除
	 * */
	public String deletenews(){
		newsService.deleteNews(newsId);
		return"deletenews";
	}
	/*
	 * 根据newsId查寻新闻表
	 * （修改前置步骤）
	 * */
	public String querybynewsId(){
		news=newsService.queryByNewsId(newsId);
		itemlist=newsService.queryItem();
		return"querybynewsId";
	}
	/*
	 * 修改新闻表
	 * */
	public String updatenews(){
		news.setUpdateTime(new Date());
		newsService.updateNews(news);
		return"updatenews";
	}
	/*查寻全部item表*/
	public String queryallitem() {
		try {
			totalNum =	newsService.countItem();
			totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;
			i = totalPage.intValue();
			System.out.println("一共有"+totalNum+"条新闻，每页"+pageSize+"条记录，共"+totalPage+"页");
			if (pageNo==null) {
				pageNo=1;
			}
			itemlist=newsService.queryByPageItem(pageSize, pageNo);
			return "queryallitem";
		} catch (Exception e) {
			return "error" ;
		}
	}
	/*
	 * 添加item表
	 * */
	public String additem(){
		newsService.addItem(item);
		return "additem";
	}
	/*
	 * 根据itemId删除item表
	 * */
	public String deleteitem() {
		try {
			newsService.deleteItem(itemId);
			return "deleteitem";
		} catch (Exception e) {
			return "deleteitemerror";
		}
	}
	/*
	 * 根据itemId查寻item表
	 * （修改的前置步骤）
	 * */
	public String querybyitemid() {
		item=newsService.queryByItemId(itemId);
		return "querybyitemid";
	}
	/*
	 * 修改item表
	 * */
	public String updateitem() {
		newsService.updateItem(item);
		return"updateitem";
	}
	/*
	 * users表查询
	 *
	 * */
	public String queryallusers() {
		try {
			totalNum =	newsService.countUsers();
			totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;
			i = totalPage.intValue();
			System.out.println("一共有"+totalNum+"条新闻，每页"+pageSize+"条记录，共"+totalPage+"页");
			if (pageNo==null) {
				pageNo=1;
			}
			userslist  =  newsService.queryByPageUsers(pageSize, pageNo);
			return "queryallusers";
		} catch (Exception e) {
			return "error" ;
		}
	}
	/*
	 * 添加users
	 * */
	public String addusers() {
		newsService.addUsers(users);
		return "addusers";
	}
	/*
	 * 根据usersId删除users表
	 * */
	public String deleteusers() {
		newsService.deleteUsers(userId);
		return "deleteusers";
	}
	/*
	 * 根据usersId查寻users表
	 * （修改的前置步骤）
	 * */
	public String querybyusersid() {
		users=newsService.queryByUsersId(userId);
		return "querybyusersid";
	}
	/*
	 * 修改users表
	 * */
	public String updateusers() {
		newsService.updateUsers(users);
		return"updateusers";
	}
	/*
	 * 登录页面
	 * */
	public String login() {
		String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");  
        if(!checkcode.equalsIgnoreCase(checkcode1)){  
        	msg="验证码错误！";  
            return "loginerror";  
        }  else{
        	System.out.println(newsService.queryUsersName(name,pwd));
    		List<Users> userslist1 =null;
    		userslist1=newsService.queryUsersName(name,pwd);
    		if (userslist1!=null && userslist1.size()>0) {
    			Map<String,Object> session=null;
				session=ActionContext.getContext().getSession();
				session.put("curr_user", userslist1.get(0));
    				return "login";
    			}else {
    				msg="账号密码有误";
    				return "loginerror";
    			}
        }
	} 
	public String logout() {
		Map<String,Object> session=null;
		session=ActionContext.getContext().getSession();
		session.clear();
		return "logout";
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
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public List<Users> getUserslist() {
		return userslist;
	}
	public void setUserslist(List<Users> userslist) {
		this.userslist = userslist;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	
}
