package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Education;
import com.csye6220.recruitment.pojo.Resume;
@Repository
public class EducationDAO extends DAO {
	public void add(Education edu) {
		try {
			begin();
			getSession().save(edu);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Education get(long id) {
		Education edu = null;
		try {
			begin();
			Query q = getSession().createQuery("from Education where id= :id");
			q.setParameter("id",id);
			edu = (Education) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return edu;
	}
	
	public List<Education> list(Resume resume) {
		List<Education> edus = null;
		try {
			begin();
			Query q = getSession().createQuery("from Education where resume= :resume");
			q.setParameter("resume", resume);
			edus = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return edus;
	}
}
