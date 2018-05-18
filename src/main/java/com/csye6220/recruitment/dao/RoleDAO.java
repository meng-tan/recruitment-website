package com.csye6220.recruitment.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Role;
@Repository
public class RoleDAO extends DAO {
	public void add(Role role) {
		try {
			begin();
			getSession().save(role);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Role get(int id) {
		Role role = null;
		try {
			begin();
			Query q = getSession().createQuery("from Role where Role_ID= :Role_ID");
			q.setParameter("Role_ID", id);
			role = (Role) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return role;
	}
	
	public Role getByName(String roleName) {
		Role role = null;
		try {
			begin();
			Query q = getSession().createQuery("from Role where role= :role");
			q.setParameter("role",roleName);
			role = (Role) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return role;
	}
}
