package com.news.intercept;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LonginIntercept extends AbstractInterceptor {
	private static final long serialVersionUID = -7731005240483579017L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session= ServletActionContext.getRequest().getSession();
		if (session.getAttribute("curr_user")==null) {
			return "login1";
		}
		return invocation.invoke();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
	}

}
