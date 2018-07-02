package org.xkp.lesson.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xkp.lesson.dao.DbUserInfo;
import org.xkp.lesson.entity.UserInfo;

/**
 * Servlet implementation class ShowAllServlet
 */
@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<UserInfo> userInfos=DbUserInfo.selectAll();
		request.setAttribute("userInfos", userInfos);//��List<UserInfo>��userInfos�浽request��ΪuserInfos�У�
		//request��ΪuserInfos��Ӧjspҳ��� userInfos	<c:forEach  items="${userIdsanfos}" var="userInfo">
		//�Ӻ�̨�����ݴ���ǰ�ˣ�url�������ı䣬������
		request.getRequestDispatcher("ShowAllUserInfo.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
