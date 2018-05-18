package com.csye6220.recruitment.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.User;
@Repository
public class UserDAO extends DAO {
	public void add(User user) {
		try {
			begin();
			getSession().save(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public User get(String username) {
		User user = null;
		try {
			begin();
			Query q = getSession().createQuery("from User where username= :username");
			q.setParameter("username", username);
			user = (User) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean update(User user) {
		try {
			begin();
			getSession().update(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
