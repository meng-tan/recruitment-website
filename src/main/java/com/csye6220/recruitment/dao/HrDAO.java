package com.csye6220.recruitment.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Hr;
@Repository
public class HrDAO extends DAO {
	public void add(Hr hr) {
		try {
			begin();
			getSession().save(hr);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Hr get(String username) {
		Hr hr = null;
		try {
			begin();
			Query q = getSession().createQuery("from Hr where username= :username");
			q.setParameter("username", username);
			hr = (Hr) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return hr;
	}
	
	public Hr getById(long id) {
		Hr hr = null;
		try {
			begin();
			Query q = getSession().createQuery("from Hr where id= :id");
			q.setParameter("id", id);
			hr = (Hr) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return hr;
	}
}
