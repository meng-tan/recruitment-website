package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.User;
@Repository
public class ResumeDAO extends DAO {
	public void add(Resume resume) {
		try {
			begin();
			getSession().save(resume);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Resume getById(long id) {
		Resume resume = null;
		try {
			begin();
			Query q = getSession().createQuery("from Resume where id= :id");
			q.setParameter("id", id);
			resume = (Resume) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return resume;
	}
	
	public Resume getByResumeTitle(String resumeTitle) {
		Resume resume = null;
		try {
			begin();
			Query q = getSession().createQuery("from Resume where resumeTitle= :resumeTitle");
			q.setParameter("resumeTitle", resumeTitle);
			resume = (Resume) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return resume;
	}
	
	public List<Resume> list(User user) {
		List<Resume> resumes = null;
		try {
			begin();
			Query q = getSession().createQuery("from Resume where user= :user");
			q.setParameter("user", user);
			resumes = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return resumes;
	}
	
	public List<Resume> list() {
		List<Resume> resumes = null;
		try {
			begin();
			Query q = getSession().createQuery("from Resume");
			resumes = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return resumes;
	}
}
