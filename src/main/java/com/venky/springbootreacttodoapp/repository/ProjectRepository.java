package com.venky.springbootreacttodoapp.repository;

import com.venky.springbootreacttodoapp.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>
{
}
