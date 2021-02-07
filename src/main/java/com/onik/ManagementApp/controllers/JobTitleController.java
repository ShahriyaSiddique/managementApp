package com.onik.ManagementApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onik.ManagementApp.models.JobTitle;
import com.onik.ManagementApp.services.JobTitleService;

@Controller
@RequestMapping("/jobtitles")
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("")
	public String findAll(Model model) {
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());

		return "jobTitle";
	}

	@GetMapping("/findById")
	@ResponseBody
	public Optional<JobTitle> findById(Integer id) {
		return jobTitleService.findById(id);
	}

	@PostMapping("/addnew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteById(Integer id) {
		jobTitleService.deleteById(id);
		return "redirect:/jobTitles";
	}
}
