package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.JobTitle;
import com.onik.ManagementApp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;

	public List<JobTitle> getJobTitles() {
		return jobTitleRepository.findAll();
	}

	public Optional<JobTitle> findById(Integer id) {
		return jobTitleRepository.findById(id);
	}

	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	public void deleteById(Integer id) {
		jobTitleRepository.deleteById(id);
	}

}
