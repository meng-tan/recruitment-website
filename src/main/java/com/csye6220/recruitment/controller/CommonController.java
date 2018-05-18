package com.csye6220.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csye6220.recruitment.dao.PostDAO;
import com.csye6220.recruitment.dao.ResumeDAO;
import com.csye6220.recruitment.pojo.Post;
import com.csye6220.recruitment.pojo.Resume;

@Controller
public class CommonController {
	
	@Autowired
	private ResumeDAO resumeDAO;
	
	@Autowired
	private PostDAO postDAO;
	

	@RequestMapping(value = "/**/viewResume", method = RequestMethod.POST)
	public String viewResumeByPost(@RequestParam("Resume_ID") long id,ModelMap model) {
		Resume resume = resumeDAO.getById(id);
		model.addAttribute("resume",resume);
		return "view-resume";
	}
	
	@RequestMapping(value = "/**/viewResume/{resumeId}", method = RequestMethod.GET)
	public String viewResumeByGet(@PathVariable long resumeId,ModelMap model) {
		Resume resume = resumeDAO.getById(resumeId);
		model.addAttribute("resume",resume);
		return "view-resume";
	}
	
	@RequestMapping(value = "/**/viewPost", method = RequestMethod.POST)
	public String viewPostByPost(@RequestParam("Post_ID") long id,ModelMap model) {
		Post post = postDAO.getById(id);
		model.addAttribute("post",post);
		return "view-post";
	}
	
	@RequestMapping(value = "/**/viewPost/{postId}", method = RequestMethod.GET)
	public String viewPostByGet(@PathVariable long postId,ModelMap model) {
		Post post = postDAO.getById(postId);
		model.addAttribute("post",post);
		return "view-post";
	}
}
