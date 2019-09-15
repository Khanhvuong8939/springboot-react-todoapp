package com.venky.springbootreacttodoapp.service;

import com.venky.springbootreacttodoapp.domain.Project;
import com.venky.springbootreacttodoapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService
{
	@Autowired
	ProjectRepository projectRepository;

	public Project saveProject(Project project)
	{
		return projectRepository.save(project);
	}
}
