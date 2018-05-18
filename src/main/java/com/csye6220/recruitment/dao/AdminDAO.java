package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.csye6220.recruitment.pojo.Admin;
import com.csye6220.recruitment.pojo.Post;
@Repository
public class AdminDAO extends DAO {
	public void add(Admin admin) {
		try {
			begin();
			getSession().save(admin);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Admin get(String username) {
		Admin admin = null;
		try {
			begin();
			Query q = getSession().createQuery("from Admin where username= :username");
			q.setParameter("username", username);
			admin = (Admin) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return admin;
	}
	
	public Admin getById(long id) {
		Admin admin = null;
		try {
			begin();
			Query q = getSession().createQuery("from Admin where id= :id");
			q.setParameter("id", id);
			admin = (Admin) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return admin;
	}
	
	public List<Admin> list() {
		List<Admin> admins = null;
		try {
			begin();
			Query q = getSession().createQuery("from Admin");
			admins = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return admins;
	}
}
