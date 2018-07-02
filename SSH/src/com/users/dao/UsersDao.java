package com.users.dao;

import java.util.List;
import com.news.entity.Users;

public interface UsersDao {
	public List<Users> queryallUsers();
	public Integer addUsers(Users users);
	public void deleteUsers(Integer userId);
	public Users queryByUsersId(Integer userId);
	public void updateUsers(Users users);
	public List<Users> queryByPageUsers(Integer pageSize,Integer pageNo );
	public Long countUsers();
	public List<Users> queryUsersName(String name ,String pwd);
//	public Users  queryUsersName(String name);
	List<Users> fuzzyqueryUsers(String character);
}
