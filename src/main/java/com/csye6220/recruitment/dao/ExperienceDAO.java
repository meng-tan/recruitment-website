package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Experience;
import com.csye6220.recruitment.pojo.Resume;
@Repository
public class ExperienceDAO extends DAO {
	public void add(Experience exp) {
		try {
			begin();
			getSession().save(exp);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public List<Experience> list(Resume resume) {
		List<Experience> exps = null;
		try {
			begin();
			Query q = getSession().createQuery("from Experience where resume= :resume");
			q.setParameter("resume", resume);
			exps = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return exps;
	}
}
