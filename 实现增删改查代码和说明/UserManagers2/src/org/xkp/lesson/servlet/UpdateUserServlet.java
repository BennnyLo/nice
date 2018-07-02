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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		request.setCharacterEncoding("utf-8");
		 int userId=Integer.parseInt( request.getParameter("userId"));
		 String userName=request.getParameter("userName");
		 String userPwd=request.getParameter("userPwd");
		 int userAge=Integer.parseInt(request.getParameter("userAge"));
		 String userSex=request.getParameter("userSex");
		 UserInfo userInfo=new UserInfo(userId,userName,userPwd,userAge,userSex);
		 DbUserInfo.updateUserInfo(userInfo);
		 //从前端把数据传给后台，用response
		 response.sendRedirect("ShowAllServlet");
	}

}
