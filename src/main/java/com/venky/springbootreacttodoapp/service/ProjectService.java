package com.venky.springbootreacttodoapp.service;

import com.venky.springbootreacttodoapp.domain.Project;
import com.venky.springbootreacttodoapp.exceptions.ProjectIdException;
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
		project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
		try
		{
			return projectRepository.save(project);
		}
		catch (Exception e)
		{
			throw new ProjectIdException("Project Identifier: " + project.getProjectIdentifier() + " is existed!!!");
		}
	}
}
