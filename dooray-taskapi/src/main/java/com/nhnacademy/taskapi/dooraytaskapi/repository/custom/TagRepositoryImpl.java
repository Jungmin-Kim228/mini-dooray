package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProject;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QTag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Tag;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TagRepositoryImpl extends QuerydslRepositorySupport implements TagRepositoryCustom {
    public TagRepositoryImpl() {
        super(Tag.class);
    }

    @Override
    public List<TagDto> getTagProjectNo(Integer no) {
        QTag tag = QTag.tag;
        QProject project = QProject.project;

        return from(tag)
            .innerJoin(project).on(tag.project.projectNo.eq(project.projectNo))
            .where(project.projectNo.eq(no))
            .select(Projections.bean(TagDto.class,
                tag.tagNo,
                tag.tagName))
            .fetch();
    }
}
