package org.xkp.lesson.dao;
//连接数据库，固定模板
import java.sql.Connection;//导入java.sql.connection
import java.sql.DriverManager;//导入java.sql。DriverManager
import java.sql.SQLException;//导入java.sql.SQLException
//连接数据库
public class DbConn {
       private static String user="root";
       private static String password="123456";
       private static String url="jdbc:mysql://localhost:3306/userdata?"
       		+ "characterEncoding=utf-8";//修改数据库名称userdata
       private static String Driver="com.mysql.jdbc.Driver";
       private static Connection connection=null;
//获取与数据库的连接,以单例模式获取连接
public static Connection getConn() {
	if(connection==null) {
       try{
    	   //加载驱动
    	   Class.forName(Driver);
    	   //通过驱动管理器获取与数据库的连接
    	   connection =DriverManager.getConnection(url, user, password);
       }catch(ClassNotFoundException e) {
    	   e.printStackTrace();
       }catch(SQLException e) {
    	   e.printStackTrace();
       }		
	}
	return connection;
}

//关闭连接
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