package org.xkp.lesson.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xkp.lesson.dao.DbUserInfo;
import org.xkp.lesson.entity.UserInfo;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
     	String userName=request.getParameter("userName");//获取前端jsp页面名为的userName的值
     	String userPwd=request.getParameter("userPwd");
     	String userSex=request.getParameter("userSex");
     	int userAge=Integer.parseInt(request.getParameter("userAge")); 
     	UserInfo userInfo =new UserInfo(userName,userPwd,userAge,userSex);
     	DbUserInfo.addUser(userInfo);
     	//前端把数据传给后台，响应,response
     	response.sendRedirect("ShowAllServlet");
     	
	}

}
