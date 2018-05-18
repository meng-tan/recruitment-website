package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.Skill;
@Repository
public class SkillDAO extends DAO {
	public void add(Skill skill) {
		try {
			begin();
			getSession().save(skill);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public List<Skill> list(Resume resume) {
		List<Skill> skills = null;
		try {
			begin();
			Query q = getSession().createQuery("from Skill where resume= :resume");
			q.setParameter("resume", resume);
			skills = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return skills;
	}
}
