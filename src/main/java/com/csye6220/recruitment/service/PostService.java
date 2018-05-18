package com.csye6220.recruitment.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.recruitment.dao.PostDAO;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
@Service
public class PostService {
	@Autowired
	private PostDAO postDAO;

	public void add(Hr hr,Post post) {
		post.setHr(hr);
		postDAO.add(post);
		if(hr.getPosts()==null) {hr.setPosts(new ArrayList<Post>());}
		hr.getPosts().add(post);
	}
}
