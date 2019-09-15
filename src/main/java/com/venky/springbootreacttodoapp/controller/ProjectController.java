package com.venky.springbootreacttodoapp.controller;

import com.venky.springbootreacttodoapp.domain.Project;
import com.venky.springbootreacttodoapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/project")
public class ProjectController extends AbstractController
{

	@Autowired
	ProjectService projectService;

	@PostMapping
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result)
	{
		if (result.hasErrors())
		{
			return mapValidError(result);
		}

		Project projectCreated = projectService.saveProject(project);
		return new ResponseEntity<>(projectCreated, HttpStatus.CREATED);
	}


}
