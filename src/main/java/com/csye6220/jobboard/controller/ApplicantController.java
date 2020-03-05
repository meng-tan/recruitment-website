package com.csye6220.jobboard.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csye6220.jobboard.model.Applicant;
import com.csye6220.jobboard.model.Application;
import com.csye6220.jobboard.model.Education;
import com.csye6220.jobboard.model.Experience;
import com.csye6220.jobboard.model.Resume;
import com.csye6220.jobboard.service.ApplicationService;
import com.csye6220.jobboard.service.ResumeService;

@Controller
public class ApplicantController {
	
	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping(value = "/new-resume", method = RequestMethod.GET)
	public String newResume(HttpServletRequest request, Model model) {
		model.addAttribute("resume", new Resume());
		return "new-resume";
	}
	
	@RequestMapping(value = "/new-resume", method = RequestMethod.POST)
	public String postResume(HttpServletRequest request, @ModelAttribute("resume") Resume resume) {
		HttpSession session = request.getSession();
		Applicant applicant = (Applicant) session.getAttribute("applicant");
		resume.setApplicant(applicant);

		String[] eduFrom = request.getParameterValues("eduFrom");
		String[] eduTo = request.getParameterValues("eduTo");
		String[] university = request.getParameterValues("university");
		String[] degree = request.getParameterValues("degree");
		String[] major = request.getParameterValues("major");

		List<Education> edus = new ArrayList<Education>();
		for (int i = 0; i < eduFrom.length; i++) {
			Education edu = new Education();
			edu.setStartYear(eduFrom[i]);
			edu.setEndYear(eduTo[i]);
			edu.setUniversity(university[i]);
			edu.setDegree(degree[i]);
			edu.setMajor(major[i]);
			edu.setResume(resume);
			edus.add(edu);
		}
		resume.setEducations(edus);

		String[] expFrom = request.getParameterValues("expFrom");
		String[] expTo = request.getParameterValues("expTo");
		String[] company = request.getParameterValues("company");
		String[] position = request.getParameterValues("position");
		String[] category = request.getParameterValues("category");
		String[] responsibilities = request.getParameterValues("responsibilities");

		List<Experience> exps = new ArrayList<Experience>();
		for (int i = 0; i < expFrom.length; i++) {
			Experience exp = new Experience();
			exp.setStartYear(expFrom[i]);
			exp.setEndYear(expTo[i]);
			exp.setCompany(company[i]);
			exp.setPosition(position[i]);
			exp.setCategory(category[i]);
			exp.setResponsibilities(responsibilities[i]);
			exp.setResume(resume);
			exps.add(exp);
		}
		resume.setExperiences(exps);
		
		LocalDateTime localDate = LocalDateTime.now();
		resume.setCreateDate(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm").format(localDate));
		resumeService.create(resume);
		return "redirect:/applicant-dashboard";
	}

	@RequestMapping(value = "/position/{positionId}/apply", method = RequestMethod.POST)
	public String apply(HttpServletRequest request, @PathVariable String positionId,
			@RequestParam("resumeId") String resumeId, Model model) {
		HttpSession session = request.getSession();
		Applicant applicant = (Applicant) session.getAttribute("applicant");
		if (applicationService.create(applicant, Integer.valueOf(resumeId), Integer.valueOf(positionId))) {
			model.addAttribute("message", "Successfully applied!");
		} else {
			model.addAttribute("message", "Already applied once.");
		}
		return "message";
	}
	
	@RequestMapping(value="/check-applications",method=RequestMethod.GET)
	protected String checkApplications(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		Applicant applicant = (Applicant) session.getAttribute("applicant");
		List<Application> applications = applicationService.findByApplicant(applicant);
		model.addAttribute("applications",applications);
		return "check-applications";
	}

}
