package com.venky.springbootreacttodoapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.venky.springbootreacttodoapp.domain.master.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity
public class Project extends BaseModel implements Serializable
{
	@NotBlank(message = "Project name is required")
	private String projectName;

	@NotBlank(message = "Project identifier is required")
	@Size(min = 4, max = 5, message = "Project identifier have 4 or 5 character")
	@Column(updatable = false, unique = true)
	private String projectIdentifier;

	@NotBlank(message = "Project description is required")
	private String description;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
}
