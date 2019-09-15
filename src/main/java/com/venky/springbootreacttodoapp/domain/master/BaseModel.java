package com.venky.springbootreacttodoapp.domain.master;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@CreatedDate
	protected Date createdDate;

	@CreatedBy
	protected String createdBy;

	@LastModifiedBy
	@JsonFormat(pattern = "yyyy-mm-dd")
	protected String modifiedBy;

	@LastModifiedDate
	@JsonFormat(pattern = "yyyy-mm-dd")
	protected Date modifiedDate;

	protected boolean enable = true;


}
