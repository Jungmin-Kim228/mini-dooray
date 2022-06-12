package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QMilestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProject;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MilestoneRepositoryImpl extends QuerydslRepositorySupport implements MilestoneRepositoryCustom {
    public MilestoneRepositoryImpl() {
        super(Milestone.class);
    }

    @Override
    public List<MilestoneDto> getMilestoneByProjectNo(Integer no) {
        QMilestone milestone = QMilestone.milestone;
        QProject project = QProject.project;

        return from(milestone)
            .innerJoin(project).on(milestone.project.projectNo.eq(project.projectNo))
            .where(project.projectNo.eq(no))
            .select(Projections.bean(MilestoneDto.class,
                milestone.milestoneNo,
                milestone.milestoneName))
            .fetch();
    }
}
