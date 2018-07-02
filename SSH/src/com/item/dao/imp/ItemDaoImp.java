package com.item.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.item.dao.ItemDao;
import com.news.entity.Item;
import com.news.entity.News;
@Repository("itemDao")
public class ItemDaoImp implements ItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Item> queryallItem() {
		String hql = "from Item"; 
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    List<Item> list = query.list();
	    return list;
	}
	@Override
	public List<Item> fuzzyqueryItem(String character) {
		String hql="from Item as item where item.name like '%"+character+"%'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Item> list=query.list();
		return list;
	}
	@Override
	public Integer addItem(Item item ) {
		Integer result=  (Integer) sessionFactory.getCurrentSession().save(item);
	    return result;
	}

	@Override
	public void deleteItem(Integer itemId) {
		Item item=new Item();
			item.setItemId(itemId);
			sessionFactory.getCurrentSession().delete(item); 
	}

	@Override
	public Item queryByItemId(Integer itemId) {
		Item item=(Item)sessionFactory.getCurrentSession().get(Item.class, itemId); 
	    return item;
	}

	@Override
	public void updateItem(Item item) {
		sessionFactory.getCurrentSession().update(item);
		
	}
	public List<Item> queryByPageItem(Integer pageSize,Integer pageNo ) {
	    String hql = "from Item"; 
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    query.setMaxResults(pageSize);
	    query.setFirstResult((pageNo-1)*pageSize);
	    List<Item> list=query.list();
	    return list;
}
	public Long countItem() {
	    String hql = "select count(*) from Item"; 
	    Query query = sessionFactory.getCurrentSession().createQuery(hql); 
	    Long count= (Long) query.uniqueResult();
	    return count;
}
}
