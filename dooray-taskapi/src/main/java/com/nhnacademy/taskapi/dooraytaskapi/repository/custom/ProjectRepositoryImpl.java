package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProject;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProjectUser;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ProjectRepositoryImpl extends QuerydslRepositorySupport implements ProjectRepositoryCustom {
    public ProjectRepositoryImpl() {
        super(Project.class);
    }

    @Override
    public List<ProjectDto> getOwnProjects(String id) {
        QProject project = QProject.project;
        QProjectUser projectUser = QProjectUser.projectUser;

        return from(project)
            .innerJoin(projectUser).on(project.projectNo.eq(projectUser.pk.projectNo))
            .where(projectUser.pk.userId.eq(id))
            .select(Projections.bean(ProjectDto.class,
                project.projectNo,
                project.projectName,
                project.adminId,
                project.projectStatus))
            .fetch();
    }

    @Override
    public ProjectDto getProjectDtoByProjectNo(Integer no) {
        QProject project = QProject.project;

        return from(project)
            .where(project.projectNo.eq(no))
            .select(Projections.bean(ProjectDto.class,
                project.projectNo,
                project.projectName,
                project.adminId,
                project.projectStatus))
            .fetchOne();
    }
}
