package com.news.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.news.entity.Users;
import com.news.service.NewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
	private static final long serialVersionUID = 8157030678028992405L;
	private static Logger logger=Logger.getLogger("NewsAction");
	@Autowired
	private NewsService newsService;
	private String msg;
	private String checkcode;
	private String name;
	private String pwd; 
	public String login() {
		String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");  
        if(!checkcode.equalsIgnoreCase(checkcode1)){  
        	msg="—È÷§¬Î¥ÌŒÛ£°";  
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
    				msg="’À∫≈√‹¬Î”–ŒÛ";
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
}
