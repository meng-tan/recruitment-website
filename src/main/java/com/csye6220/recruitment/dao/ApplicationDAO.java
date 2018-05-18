package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Application;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.User;

@Repository
public class ApplicationDAO extends DAO {
	public void add(Application application) {
		try {
			begin();
			getSession().save(application);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Application get(Resume resume,Post post) {
		Application application = null;
		try {
			begin();
			Query q = getSession().createQuery("from Application where resume= :resume and post= :post");
			q.setParameter("resume", resume);
			q.setParameter("post", post);
			application = (Application) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return application;
	}
	
	public Application getById(long id) {
		Application application = null;
		try {
			begin();
			Query q = getSession().createQuery("from Application where id= :id");
			q.setParameter("id",id);
			application = (Application) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return application;
	}
	
	public void update(Application application) {
		try {
			begin();
			getSession().update(application);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public List<Application> listByUser(User user) {
		List<Application> applications = null;
		try {
			begin();
			Query q = getSession().createQuery("from Application where user= :user order by applyTime");
			q.setParameter("user", user);
			applications = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return applications;
	}
	
	public List<Application> listByHr(Hr hr) {
		List<Application> applications = null;
		try {
			begin();
			Query q = getSession().createQuery("from Application where hr= :hr order by post, applyTime");
			q.setParameter("hr", hr);
			applications = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return applications;
	}
}
