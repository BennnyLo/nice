package com.news.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.news.dao.NewsDao;
import com.news.entity.Item;
import com.news.entity.News;
@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*
	 * news表增删改查
	 * */
	@Override
	public List<News> queryNews() { 
		    String hql = "FROM News"; 
		    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		    List<News> list= query.list();
		    return list;
	}

	@Override
	public Integer addNews(News news ,File upload ,String uploadContentType ,String uploadFileName) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		fis = new FileInputStream(upload);
		String path = ServletActionContext.getServletContext().getRealPath("upload");
		System.out.println("upload文件夹的绝对路径是：" + path);
		String xiangdui=("upload"+"/"+uploadFileName);
		fos = new FileOutputStream(path + "\\" + uploadFileName);
		byte[] buffer = new byte[1024];
		int length = fis.read(buffer);
		while (length > 0) {
			fos.write(buffer, 0, length);
			length = fis.read(buffer);
		}
		System.out.println("文件上传成功");
				if (fis != null)fis.close();
				if (fos != null)fos.close();
				news.setImgUrl(xiangdui);
		    Integer result=  (Integer) sessionFactory.getCurrentSession().save(news);
		    return result;
	}

	public void deleteNews(Integer newsId) {
		   News news1=new News();
		   news1.setNewsId(newsId);
		   sessionFactory.getCurrentSession().delete(news1); 
	}

	@Override
	public News queryByNewsId(Integer newsId) {
		    News news=(News)sessionFactory.getCurrentSession().get(News.class, newsId); 
		    return news;
	}

	@Override
	public void updateNews(News news) {
		sessionFactory.getCurrentSession().update(news);
	}

	@Override
	public List<Item> queryItem() {
		    String hql = "from Item"; 
		    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		    List<Item> list = query.list();
		    return list;
	}
	/*
	 * 模糊查询，新闻检索
	 * */
	public List<News> fuzzyqueryNews(String character) {
		String hql="from News as news where news.title like '%"+character+"%'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<News> list=query.list();
		return list;
	}
	/*分页页码*/
	@Override
	public Long count() {
		    String hql = "select count(*) from News"; 
		    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		    Long count= (Long) query.uniqueResult();
		    return count;
	}

	@Override
	public List<News> queryByPage(Integer pageSize,Integer pageNo ) {
		    String hql = "from News"; 
		    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		    query.setMaxResults(pageSize);
		    query.setFirstResult((pageNo-1)*pageSize);
		    List<News> list=query.list();
		    return list;
	}

	
	/*
	 * 根据item表查询news表
	 * */
	@Override
	public List<News> queryByNews(News news) { 
		    String hql = "FROM News news where news.item.name='"+news.getItem().getName()+"'"; 
		    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		    List<News> list=query.list(); 
		    return list;
	}
	
	
	
	
	/*
	 * item表查询
	 * */
	
}
