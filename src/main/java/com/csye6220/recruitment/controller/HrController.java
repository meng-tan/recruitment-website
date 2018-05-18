package com.csye6220.recruitment.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csye6220.recruitment.dao.ApplicationDAO;
import com.csye6220.recruitment.dao.ResumeDAO;
import com.csye6220.recruitment.pojo.Application;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.service.ApplicationService;
import com.csye6220.recruitment.service.PostService;
@Controller
public class HrController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ResumeDAO resumeDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping(value="/hr/addPost",method=RequestMethod.GET)
	protected String showPostForm(ModelMap model){
		model.addAttribute("post",new Post());
		return "post-form";
	}
	
	@RequestMapping(value="/hr/addPost",method=RequestMethod.POST)
	protected String addPost(HttpServletRequest request, @ModelAttribute("post") Post post,@RequestParam("companyLogo") MultipartFile file){
		HttpSession session = request.getSession();
		Hr hr = (Hr) session.getAttribute("hr");
		String savedLocalPath = "C:\\recruitmentUpload\\";
//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		String sqlPath = null;
		if(!file.isEmpty() && file.getOriginalFilename()!=null && file.getOriginalFilename().length()>0) {
	        String filename=file.getOriginalFilename();
	        String uuid = UUID.randomUUID().toString().replaceAll("-","");
	        String savedFilename = uuid+filename;
			sqlPath ="/recruitment/uploaded/"+savedFilename;
			System.out.println("sqlpath: "+sqlPath);
			try {
				byte[] bytes = file.getBytes();
				FileCopyUtils.copy(bytes, new File(savedLocalPath+savedFilename));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		post.setPicPath(sqlPath);
		postService.add(hr,post);
		return "redirect:/hr/hr-home";
	}
	
	@RequestMapping(value="/hr/resumeIndex",method=RequestMethod.GET)
	protected String showResumeIndex(ModelMap model){
		List<Resume> resumes = resumeDAO.list();
		model.addAttribute("resumes",resumes);
		return "resume-index";
	}
	
	@RequestMapping(value="/hr/processApplications",method=RequestMethod.GET)
	protected String showApplications(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		Hr hr = (Hr) session.getAttribute("hr");
		List<Application> applications = applicationDAO.listByHr(hr);
		model.addAttribute("applications",applications);
		return "process-applications";
	}
	
	@RequestMapping(value="/hr/processApplication",method=RequestMethod.POST)
	protected String processApplication(HttpServletRequest request,@RequestParam("Application_ID") long applicationId,@RequestParam("status") String status,@RequestParam("message") String message){
		applicationService.processApplication(applicationId, status, message);
		return "redirect:/hr/processApplications";
	}
}
