package org.xkp.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xkp.lesson.entity.UserInfo;

public  class DbUserInfo {
	//��
public static boolean addUser(UserInfo userInfo) {
    //1.�������ݿ�
	Connection connection=DbConn.getConn();//��
	//2.�������ݿ���Ӧ��sql���
	String sql ="INSERT INTO userInfo (userName,userPwd,userSex,userAge) "
			+ "VALUES (?,?,?,?)";
	//????��Ӧ�����1234
	try {
		//3.ͨ��sql��ȡ�����ݿ��Ԥ����,������PreparedStatement statement=connection.prepareStatement(sql);
		//����ֺ�Ķ���������ڶ���surround with try/catch,Ȼ���ס�򿪹ر�
		PreparedStatement statement=connection.prepareStatement(sql);//��
		//4.���addUser��������userInfo�� userName,userPwd,userSex,userAge��get����
		statement.setString(1, userInfo.getUserName());//����.get����
		statement.setString(2, userInfo.getUserPwd());//����.get����
		statement.setString(3, userInfo.getUserSex());//����.get����
		statement.setInt(4, userInfo.getUserAge());
		//ִ��sql
		int count=statement.executeUpdate();//�ı䶼��executeUpdate
		if(count<0) {
			return false;
		}
		
		statement.close();//�ر�
		
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
	//6.�ر����ݿ�
	DbConn.closeConn();//�ر�
	return true;
       }

//ɾ
public static boolean deleteById(int userId) {
	//1.�������ݿ�
	Connection connection=DbConn.getConn();//��
	//2.�������ݿ���Ӧ��sql���
	String sql="delete from userInfo where userId=?";//?��Ӧ1
	try {
		//3.ͨ��sql��ȡ�������ݿ��Ԥ����
		PreparedStatement statement=connection.prepareStatement(sql);//��
		//4.���deleteById��������userId
		statement.setInt(1, userId);
		//ִ��sql
		int count=statement.executeUpdate();//�ı䶼��executeUpdate
		if(count<0) {
			return false;
		}
		statement.close();//�ر�
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	//6.�ر�����
	DbConn.closeConn();//�ر�
	return true;
}

//��NO1.���Ҹ����û�
public static UserInfo selectUserId(int userId) {
	UserInfo userInfo=null;
	//1.�������ݿ�
	Connection connection=DbConn.getConn();
	//2.�������ݿ���Ӧ��sql���
	String sql="select * from userInfo where userId=?";
	try {
		//3.ͨ��sql��ȡ�����ݿ��Ԥ����,
		PreparedStatement statement=connection.prepareStatement(sql);
		//4.���selectUserId��������userId
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
//��2���޸ĸ����û�
public static boolean updateUserInfo(UserInfo userInfo) {
	//1.�������ݿ�
	Connection connection=DbConn.getConn();
	//2.�������ݿ���Ӧ��sql���
	String sql="update userInfo set userName=?,userPwd=?,userSex=?,userAge=? where userId=?";
	try {
		//3.ͨ��sql��ȡ�����ݿ��Ԥ����,
		PreparedStatement statement = connection.prepareStatement(sql);
		//4.���updateUserInfo��������userInfo
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

//��
public static List<UserInfo> selectAll(){
	//����util.list,�������飬������������<UserInfo>,����entity��class��
	ArrayList<UserInfo> userInfos=new ArrayList<>();//List<UserInfo>��ArrayList<UserInfo>�ĸ�Ԫ�أ�
	//1.�������ݿ�
	Connection connection=DbConn.getConn();//��
	//2.�������ݿ���Ӧ��sql���
	String sql="select * from userInfo";
	try {
		//3.ͨ��sql��ȡ�����ݿ��Ԥ����,����PreparedStatement statement=connection.prepareStatement(sql);
		//����ֺ�Ķ���������ڶ���surround with try/catch
		PreparedStatement statement=connection.prepareStatement(sql);//��
		//4ִ�в�ѯ���������������α�
		ResultSet set=statement.executeQuery();//����executeQuery
		//5.��next()�����������ݿ����������
		while(set.next()) {
			//��entity�ĵ�private int userId;
			//private String userName;
			//private String userPwd;
			//private int userAge;
			//private String userSex;���ƹ�����Ȼ��ɾ��private
			int userId=set.getInt("userId");
			String userName=set.getString("userName");
			String userPwd=set.getString("userPwd");
			int userAge=set.getInt("userAge");
		    String userSex=set.getString("userSex");
		    //��entity��ȫ�ι��췽������
		    UserInfo userInfo=new UserInfo(userId,userName,userPwd,userAge,userSex);
		    //������������ݣ���add����
		    userInfos.add(userInfo);
		}
		set.close();
		statement.close();//�ر�
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DbConn.closeConn();//�ر�
	return userInfos;
	
}
}
