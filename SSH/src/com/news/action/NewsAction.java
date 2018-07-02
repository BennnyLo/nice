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
	 * ���ű��Ѱȫ��
	 **/
	public String querynews() {
		try {
			totalNum =	newsService.count();
			totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;
			i = totalPage.intValue();
			System.out.println("һ����"+totalNum+"�����ţ�ÿҳ"+pageSize+"����¼����"+totalPage+"ҳ");
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
	 * ģ����ѯ�����ż���
	 * */
	public String fuzzyquerynews() {
		newslist=newsService.fuzzyqueryNews(character);
		return "fuzzyquerynews";
	}
	/*
	 * ģ����ѯ��item����
	 * */
	public String fuzzyqueryitem() {
		itemlist=newsService.fuzzyqueryItem(character);
		return "fuzzyqueryitem";
	}
	/*
	 * ģ����ѯ�����ż���
	 * */
	public String fuzzyqueryusers() {
		userslist=newsService.fuzzyqueryUsers(character);
		return "fuzzyqueryusers";
	}
	/*���ű����
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
	 * ��Ѱitem�����ű����ǰ�ò��裩
	 * */
	public String queryitem() {
		itemlist=newsService.queryItem();
		return"queryitem";
	}
	/*
	 * ���ű�ɾ��
	 * */
	public String deletenews(){
		newsService.deleteNews(newsId);
		return"deletenews";
	}
	/*
	 * ����newsId��Ѱ���ű�
	 * ���޸�ǰ�ò��裩
	 * */
	public String querybynewsId(){
		news=newsService.queryByNewsId(newsId);
		itemlist=newsService.queryItem();
		return"querybynewsId";
	}
	/*
	 * �޸����ű�
	 * */
	public String updatenews(){
		news.setUpdateTime(new Date());
		newsService.updateNews(news);
		return"updatenews";
	}
	/*��Ѱȫ��item��*/
	public String queryallitem() {
		try {
			totalNum =	newsService.countItem();
			totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;
			i = totalPage.intValue();
			System.out.println("һ����"+totalNum+"�����ţ�ÿҳ"+pageSize+"����¼����"+totalPage+"ҳ");
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
	 * ���item��
	 * */
	public String additem(){
		newsService.addItem(item);
		return "additem";
	}
	/*
	 * ����itemIdɾ��item��
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
	 * ����itemId��Ѱitem��
	 * ���޸ĵ�ǰ�ò��裩
	 * */
	public String querybyitemid() {
		item=newsService.queryByItemId(itemId);
		return "querybyitemid";
	}
	/*
	 * �޸�item��
	 * */
	public String updateitem() {
		newsService.updateItem(item);
		return"updateitem";
	}
	/*
	 * users���ѯ
	 *
	 * */
	public String queryallusers() {
		try {
			totalNum =	newsService.countUsers();
			totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;
			i = totalPage.intValue();
			System.out.println("һ����"+totalNum+"�����ţ�ÿҳ"+pageSize+"����¼����"+totalPage+"ҳ");
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
	 * ���users
	 * */
	public String addusers() {
		newsService.addUsers(users);
		return "addusers";
	}
	/*
	 * ����usersIdɾ��users��
	 * */
	public String deleteusers() {
		newsService.deleteUsers(userId);
		return "deleteusers";
	}
	/*
	 * ����usersId��Ѱusers��
	 * ���޸ĵ�ǰ�ò��裩
	 * */
	public String querybyusersid() {
		users=newsService.queryByUsersId(userId);
		return "querybyusersid";
	}
	/*
	 * �޸�users��
	 * */
	public String updateusers() {
		newsService.updateUsers(users);
		return"updateusers";
	}
	/*
	 * ��¼ҳ��
	 * */
	public String login() {
		String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");  
        if(!checkcode.equalsIgnoreCase(checkcode1)){  
        	msg="��֤�����";  
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
    				msg="�˺���������";
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
