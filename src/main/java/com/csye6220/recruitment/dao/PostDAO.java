package com.csye6220.recruitment.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
@Repository
public class PostDAO extends DAO {
	public void add(Post post) {
		try {
			begin();
			getSession().save(post);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
	
	public Post getById(long id) {
		Post post = null;
		try {
			begin();
			Query q = getSession().createQuery("from Post where id= :id");
			q.setParameter("id", id);
			post = (Post) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return post;
	}
	
	public Post getByPostTitle(String postTitle) {
		Post post = null;
		try {
			begin();
			Query q = getSession().createQuery("from Post where postTitle= :postTitle");
			q.setParameter("postTitle", postTitle);
			post = (Post) q.uniqueResult();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return post;
	}
	
	public List<Post> list(Hr hr) {
		List<Post> posts = null;
		try {
			begin();
			Query q = getSession().createQuery("from Post where hr= :hr");
			q.setParameter("hr", hr);
			posts = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return posts;
	}
	
	public List<Post> list() {
		List<Post> posts = null;
		try {
			begin();
			Query q = getSession().createQuery("from Post");
			posts = q.list();
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return posts;
	}
}
