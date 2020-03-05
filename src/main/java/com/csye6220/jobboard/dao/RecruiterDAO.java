package com.csye6220.jobboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.jobboard.model.Applicant;
import com.csye6220.jobboard.model.Recruiter;
@Repository
public class RecruiterDAO extends DAO {

	
	public void create(Recruiter recruiter) {
		try {
			begin();
			getSession().save(recruiter);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}

	public Recruiter findByUsername(String username) {
		Recruiter recruiter = null;
		try {
			begin();
			Query q = getSession().createQuery("from Recruiter where username= :username");
			q.setParameter("username",username);
			recruiter = (Recruiter)q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return recruiter;
	}
}
