package org.xkp.lesson.entity;
//entity层只用手写private 表行类型  表行行名;
//然后用工具生成3个构造方法，表行set,get方法，toString方法
//构造方法:1.全参构造方法，右击source-Generate Constructor using Fields (GCUF),全选中
//构造方法:2.有参构造方法，不选id，其他都选中
//表行set,get方法。右击source,Generate Getters and Setters(GGAS)，全选中
//toString方法。右击source，Generate toString()
public class UserInfo {
	

	private int userId;
	private String userName;
	private String userPwd;
	private int userAge;
	private String userSex;

	public UserInfo() {
		//无参构造方法，类名相同，参数不同,为什么要写无参的构造方法？
		//先调用父类无参的构造方法，然后再执行子类的构造方法，
	}
	public UserInfo(int userId, String userName, String userPwd, int userAge, String userSex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAge = userAge;
		this.userSex = userSex;
	}

	public UserInfo(String userName,String userPwd,int userAge,String userSex) {
		super();//调用object对象
		this.userName=userName;//按下ctrl键，this.指的是new一个变量
		this.userPwd=userPwd;
		this.userAge=userAge;
		this.userSex=userSex;
	}
	//set方法，get方法：右击source-点击Generate Getters and Setters，选择属性
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Override
	//为什么要写这个？把UserInfo的返回值变成userId=，userName=,形式
	public String toString() {
		return "UserInfo [userId=" + userId + ",userName=" + userName + ",userPwd=" +userPwd+ ",userAge=" +userAge+ ",userSex=" +userSex+ "]";
	}

}
