package com.users.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.news.entity.Item;
import com.news.entity.Users;
import com.users.dao.UsersDao;


@Repository("usersDao")
public class UsersDaoImpl implements UsersDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Users> queryallUsers() {
		String hql = "from Users"; 
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    List<Users> list = query.list();
	    return list;
	}
	@Override
	public List<Users> fuzzyqueryUsers(String character) {
		String hql="from Users as users where users.name like '%"+character+"%'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list=query.list();
		return list;
	}
	public List<Users> queryUsersName(String name,String pwd) {
		String hql="from Users where name='"+name+"' and pwd='"+pwd+"'";
		Query users=sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list = users.list();
		return list;
	}
//	public Users  queryUsersName(String name) {
//		Users users=(Users)sessionFactory.getCurrentSession().get(Users.class, name); 
//		return users;
//	}
	@Override
	public Integer addUsers(Users users) {
		Integer result=  (Integer) sessionFactory.getCurrentSession().save(users);
	    return result;
	}

	@Override
	public void deleteUsers(Integer userId) {
		 Users users =new Users();
		 users.setUserId(userId);
		 System.out.println(users.getUserId() + users.getName());
//		 String hql = "Delete FROM Users Where userId="+userId;
//		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 sessionFactory.getCurrentSession().delete(users);
	}

	@Override
	public Users queryByUsersId(Integer userId) {
		Users users=(Users)sessionFactory.getCurrentSession().get(Users.class, userId); 
	    return users;
	}

	@Override
	public void updateUsers(Users users) {
		sessionFactory.getCurrentSession().update(users);
	}
	@Override
	public List<Users> queryByPageUsers(Integer pageSize, Integer pageNo) {
		String hql = "from Users"; 
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    query.setMaxResults(pageSize);
	    query.setFirstResult((pageNo-1)*pageSize);
	    List<Users> list=query.list();
	    return list;
	}

	@Override
	public Long countUsers() {
		String hql = "select count(*) from Users"; 
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    Long count= (Long) query.uniqueResult();
	    return count;
	}

}
