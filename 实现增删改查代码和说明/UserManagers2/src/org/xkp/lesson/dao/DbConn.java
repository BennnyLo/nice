package org.xkp.lesson.dao;
//�������ݿ⣬�̶�ģ��
import java.sql.Connection;//����java.sql.connection
import java.sql.DriverManager;//����java.sql��DriverManager
import java.sql.SQLException;//����java.sql.SQLException
//�������ݿ�
public class DbConn {
       private static String user="root";
       private static String password="123456";
       private static String url="jdbc:mysql://localhost:3306/userdata?"
       		+ "characterEncoding=utf-8";//�޸����ݿ�����userdata
       private static String Driver="com.mysql.jdbc.Driver";
       private static Connection connection=null;
//��ȡ�����ݿ������,�Ե���ģʽ��ȡ����
public static Connection getConn() {
	if(connection==null) {
       try{
    	   //��������
    	   Class.forName(Driver);
    	   //ͨ��������������ȡ�����ݿ������
    	   connection =DriverManager.getConnection(url, user, password);
       }catch(ClassNotFoundException e) {
    	   e.printStackTrace();
       }catch(SQLException e) {
    	   e.printStackTrace();
       }		
	}
	return connection;
}

//�ر�����
public static void closeConn() {
	if(connection!=null) {
		try {
			connection.close();
			connection=null;
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

}