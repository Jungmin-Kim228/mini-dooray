package com.nhnacademy.taskapi.dooraytaskapi.repository;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.repository.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>,
    ProjectRepositoryCustom {

}
