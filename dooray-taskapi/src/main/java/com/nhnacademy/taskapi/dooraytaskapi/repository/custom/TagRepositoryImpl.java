package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TagDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProject;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QTag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QTaskTag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Tag;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TagRepositoryImpl extends QuerydslRepositorySupport implements TagRepositoryCustom {
    public TagRepositoryImpl() {
        super(Tag.class);
    }

    @Override
    public List<TagDto> getTagsByProjectNo(Integer no) {
        QTag tag = QTag.tag;

        return from(tag)
            .where(tag.project.projectNo.eq(no))
            .select(Projections.bean(TagDto.class,
                tag.tagNo,
                tag.tagName))
            .fetch();
    }

    @Override
    public List<TagDto> getTagDtosByTaskNo(Integer taskNo) {
        QTag tag = QTag.tag;
        QTaskTag taskTag = QTaskTag.taskTag;

        return from(tag)
            .innerJoin(taskTag).on(tag.tagNo.eq(taskTag.pk.tagNo))
            .where(taskTag.pk.taskNo.eq(taskNo))
            .select(Projections.bean(TagDto.class,
                tag.tagNo,
                tag.tagName))
            .fetch();
    }
}
