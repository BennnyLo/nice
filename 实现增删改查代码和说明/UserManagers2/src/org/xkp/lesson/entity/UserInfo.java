package org.xkp.lesson.entity;
//entity��ֻ����дprivate ��������  ��������;
//Ȼ���ù�������3�����췽��������set,get������toString����
//���췽��:1.ȫ�ι��췽�����һ�source-Generate Constructor using Fields (GCUF),ȫѡ��
//���췽��:2.�вι��췽������ѡid��������ѡ��
//����set,get�������һ�source,Generate Getters and Setters(GGAS)��ȫѡ��
//toString�������һ�source��Generate toString()
public class UserInfo {
	

	private int userId;
	private String userName;
	private String userPwd;
	private int userAge;
	private String userSex;

	public UserInfo() {
		//�޲ι��췽����������ͬ��������ͬ,ΪʲôҪд�޲εĹ��췽����
		//�ȵ��ø����޲εĹ��췽����Ȼ����ִ������Ĺ��췽����
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
		super();//����object����
		this.userName=userName;//����ctrl����this.ָ����newһ������
		this.userPwd=userPwd;
		this.userAge=userAge;
		this.userSex=userSex;
	}
	//set������get�������һ�source-���Generate Getters and Setters��ѡ������
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
	//ΪʲôҪд�������UserInfo�ķ���ֵ���userId=��userName=,��ʽ
	public String toString() {
		return "UserInfo [userId=" + userId + ",userName=" + userName + ",userPwd=" +userPwd+ ",userAge=" +userAge+ ",userSex=" +userSex+ "]";
	}

}
