package com.csye6220.recruitment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csye6220.recruitment.dao.ApplicationDAO;
import com.csye6220.recruitment.dao.HrDAO;
import com.csye6220.recruitment.dao.PostDAO;
import com.csye6220.recruitment.dao.ResumeDAO;
import com.csye6220.recruitment.pojo.Application;
import com.csye6220.recruitment.pojo.Hr;
import com.csye6220.recruitment.pojo.Post;
import com.csye6220.recruitment.pojo.Resume;
import com.csye6220.recruitment.pojo.User;
import com.csye6220.recruitment.service.ApplicationService;
import com.csye6220.recruitment.service.EducationService;
import com.csye6220.recruitment.service.ExperienceService;
import com.csye6220.recruitment.service.ResumeService;
import com.csye6220.recruitment.service.SkillService;


@Controller
public class UserController {

	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private EducationService eduService;
	
	@Autowired
	private ExperienceService expService;
	
	@Autowired
	private HrDAO hrDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private ResumeDAO resumeDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping(value="/user/addResume",method=RequestMethod.GET)
	protected String showResumeForm(ModelMap model){
		model.addAttribute("resume",new Resume());
		return "resume-form";
	}
	
	@RequestMapping(value="/user/addResume",method=RequestMethod.POST)
	protected String addResume(HttpServletRequest request, @ModelAttribute("resume") Resume resume){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		resumeService.add(user,resume);
		
		String[] skill=request.getParameterValues("skill");
		skillService.add(resume, skill);

		String[] eduFrom=request.getParameterValues("eduFrom");
		String[] eduTo =request.getParameterValues("eduTo");
		String[] university=request.getParameterValues("university");
		String[] degree=request.getParameterValues("degree");
		String[] major=request.getParameterValues("major");
		eduService.add(resume, eduFrom, eduTo, university, degree,major);
		
		String[] expFrom=request.getParameterValues("expFrom");
		String[] expTo=request.getParameterValues("expTo");
		String[] company=request.getParameterValues("company");
		String[] title=request.getParameterValues("title");
		String[] responsibility=request.getParameterValues("responsibility");
		expService.add(resume, expFrom, expTo, company, title, responsibility);
		
		//System.out.println("user resumes:"+user.getResumes());
		
		return "redirect:/user/user-home";
	}
	
	@RequestMapping(value="/user/jobIndex",method=RequestMethod.GET)
	protected String showJobIndex(ModelMap model){
		List<Post> posts = postDAO.list();
		model.addAttribute("posts",posts);
		return "job-index";
	}
	
	@RequestMapping(value="/user/applyPost",method=RequestMethod.POST)
	protected String applyPost(HttpServletRequest request,@RequestParam("Resume_ID") long Rid,@RequestParam("Post_ID") long Pid,@RequestParam("Hr_ID") long Hid,@RequestParam("coverLetter") String coverLetter,ModelMap model){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Hr hr = hrDAO.getById(Hid);
		Post post = postDAO.getById(Pid);
		Resume resume = resumeDAO.getById(Rid);
		if(applicationService.add(user,hr,resume,post,coverLetter)) {
			model.addAttribute("message","Successfully applied!");
		}else {
			model.addAttribute("message","Already applied once.");
		}
		return "message";
	}
	
	@RequestMapping(value="/user/viewApplications",method=RequestMethod.GET)
	protected String showApplications(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Application> applications = applicationDAO.listByUser(user);
		model.addAttribute("applications",applications);
		return "view-applications";
	}
}
