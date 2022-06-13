package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.ProjectUser;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProject;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProjectUser;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ProjectUserRepositoryImpl extends QuerydslRepositorySupport implements ProjectUserRepositoryCustom {
    public ProjectUserRepositoryImpl() {
        super(ProjectUser.class);
    }

    @Override
    public List<ProjectUserDto> getProjectUserByProjectNo(Integer no) {
        QProjectUser projectUser = QProjectUser.projectUser;
        QProject project = QProject.project;

        return from(projectUser)
            .innerJoin(project).on(projectUser.pk.projectNo.eq(project.projectNo))
            .where(project.projectNo.eq(no))
            .select(Projections.bean(ProjectUserDto.class,
                projectUser.pk.userId))
            .fetch();
    }

}
