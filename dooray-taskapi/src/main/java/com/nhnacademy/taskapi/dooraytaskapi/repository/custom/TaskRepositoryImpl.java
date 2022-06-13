package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QProject;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QTask;
import com.nhnacademy.taskapi.dooraytaskapi.entity.QTaskTag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Task;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TaskRepositoryImpl extends QuerydslRepositorySupport implements TaskRepositoryCustom {
    public TaskRepositoryImpl() {
        super(Task.class);
    }

    @Override
    public List<TaskDto> getTaskByProjectNo(Integer no) {
        QTask task = QTask.task;
        QProject project = QProject.project;

        return from(task)
            .innerJoin(project).on(task.project.projectNo.eq(project.projectNo))
            .where(project.projectNo.eq(no))
            .select(Projections.bean(TaskDto.class,
                task.taskNo,
                task.taskTitle,
                task.taskRegistrant,
                task.taskContent))
            .fetch();
    }

    @Override
    public TaskDto getTaskDtoByTaskNo(Integer no) {
        QTask task = QTask.task;

        return from(task)
            .where(task.taskNo.eq(no))
            .select(Projections.bean(TaskDto.class,
                task.taskNo,
                task.taskTitle,
                task.taskRegistrant,
                task.taskContent))
            .fetchOne();
    }

    @Override
    public List<Task> findTasksByTagNo(Integer tagNo) {
        QTask task = QTask.task;
        QTaskTag taskTag = QTaskTag.taskTag;

        return from(task)
            .innerJoin(taskTag).on(task.taskNo.eq(taskTag.pk.taskNo))
            .where(taskTag.pk.tagNo.eq(tagNo))
            .select(task)
            .fetch();
    }
}
