package com.csye6220.jobboard.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.jobboard.model.Applicant;
import com.csye6220.jobboard.model.Position;

@Repository
public class ApplicantDAO extends DAO {
	
	public void create(Applicant applicant) {
		try {
			begin();
			getSession().save(applicant);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}

	public Applicant findByUsername(String username) {
		Applicant applicant = null;
		try {
			begin();
			Query q = getSession().createQuery("from Applicant where username= :username");
			q.setParameter("username",username);
			applicant = (Applicant)q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return applicant;
	}

}
