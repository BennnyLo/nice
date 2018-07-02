package org.xkp.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xkp.lesson.entity.UserInfo;

public  class DbUserInfo {
	//增
public static boolean addUser(UserInfo userInfo) {
    //1.连接数据库
	Connection connection=DbConn.getConn();//打开
	//2.操作数据库相应的sql语句
	String sql ="INSERT INTO userInfo (userName,userPwd,userSex,userAge) "
			+ "VALUES (?,?,?,?)";
	//????对应下面的1234
	try {
		//3.通过sql获取对数据库的预操作,先输入PreparedStatement statement=connection.prepareStatement(sql);
		//后出现红的东西，点击第二个surround with try/catch,然后记住打开关闭
		PreparedStatement statement=connection.prepareStatement(sql);//打开
		//4.添加addUser方法参数userInfo的 userName,userPwd,userSex,userAge的get方法
		statement.setString(1, userInfo.getUserName());//参数.get方法
		statement.setString(2, userInfo.getUserPwd());//参数.get方法
		statement.setString(3, userInfo.getUserSex());//参数.get方法
		statement.setInt(4, userInfo.getUserAge());
		//执行sql
		int count=statement.executeUpdate();//改变都是executeUpdate
		if(count<0) {
			return false;
		}
		
		statement.close();//关闭
		
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	//6.关闭数据库
	DbConn.closeConn();//关闭
	return true;
       }

//删
public static boolean deleteById(int userId) {
	//1.连接数据库
	Connection connection=DbConn.getConn();//打开
	//2.操作数据库相应的sql语句
	String sql="delete from userInfo where userId=?";//?对应1
	try {
		//3.通过sql获取对象数据库的预操作
		PreparedStatement statement=connection.prepareStatement(sql);//打开
		//4.添加deleteById方法参数userId
		statement.setInt(1, userId);
		//执行sql
		int count=statement.executeUpdate();//改变都是executeUpdate
		if(count<0) {
			return false;
		}
		statement.close();//关闭
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	//6.关闭数据
	DbConn.closeConn();//关闭
	return true;
}

//改NO1.查找个人用户
public static UserInfo selectUserId(int userId) {
	UserInfo userInfo=null;
	//1.连接数据库
	Connection connection=DbConn.getConn();
	//2.操作数据库相应的sql语句
	String sql="select * from userInfo where userId=?";
	try {
		//3.通过sql获取对数据库的预操作,
		PreparedStatement statement=connection.prepareStatement(sql);
		//4.添加selectUserId方法参数userId
		statement.setInt(1, userId);
		ResultSet set=statement.executeQuery();
		while(set.next()) {
			 String userName=set.getString("userName");
			 String userPwd=set.getString("userPwd");
			 int userAge=set.getInt("userAge");
			 String userSex=set.getString("userSex");
			 
			 userInfo=new UserInfo(userId,userName,userPwd,userAge,userSex);
			 break;
		}
		set.close();
		statement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DbConn.closeConn();
	return userInfo;
}
//改2，修改个人用户
public static boolean updateUserInfo(UserInfo userInfo) {
	//1.连接数据库
	Connection connection=DbConn.getConn();
	//2.操作数据库相应的sql语句
	String sql="update userInfo set userName=?,userPwd=?,userSex=?,userAge=? where userId=?";
	try {
		//3.通过sql获取对数据库的预操作,
		PreparedStatement statement = connection.prepareStatement(sql);
		//4.添加updateUserInfo方法参数userInfo
		statement.setString(1, userInfo.getUserName());
		statement.setString(2, userInfo.getUserPwd());
		statement.setString(3, userInfo.getUserSex());
		statement.setInt(4, userInfo.getUserAge());
		statement.setInt(5, userInfo.getUserId());
	    int count=statement.executeUpdate();
	    if(count<0) {
	    	return false;
	    }
	    statement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
			DbConn.closeConn();
			return true;
}

//查
public static List<UserInfo> selectAll(){
	//导入util.list,创建数组，该数组内容是<UserInfo>,就是entity的class名
	ArrayList<UserInfo> userInfos=new ArrayList<>();//List<UserInfo>是ArrayList<UserInfo>的父元素，
	//1.连接数据库
	Connection connection=DbConn.getConn();//打开
	//2.操作数据库相应的sql语句
	String sql="select * from userInfo";
	try {
		//3.通过sql获取对数据库的预操作,输入PreparedStatement statement=connection.prepareStatement(sql);
		//后出现红的东西，点击第二个surround with try/catch
		PreparedStatement statement=connection.prepareStatement(sql);//打开
		//4执行查询动作，返回数据游标
		ResultSet set=statement.executeQuery();//查是executeQuery
		//5.用next()方法遍历数据库的所有数据
		while(set.next()) {
			//把entity的的private int userId;
			//private String userName;
			//private String userPwd;
			//private int userAge;
			//private String userSex;复制过来，然后删除private
			int userId=set.getInt("userId");
			String userName=set.getString("userName");
			String userPwd=set.getString("userPwd");
			int userAge=set.getInt("userAge");
		    String userSex=set.getString("userSex");
		    //把entity的全参构造方法复制
		    UserInfo userInfo=new UserInfo(userId,userName,userPwd,userAge,userSex);
		    //向数组添加数据，用add方法
		    userInfos.add(userInfo);
		}
		set.close();
		statement.close();//关闭
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DbConn.closeConn();//关闭
	return userInfos;
	
}
}
