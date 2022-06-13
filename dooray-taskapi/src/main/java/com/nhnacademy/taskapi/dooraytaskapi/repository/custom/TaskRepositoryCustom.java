package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Task;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TaskRepositoryCustom {

    List<TaskDto> getTaskByProjectNo(Integer no);

    TaskDto getTaskDtoByTaskNo(Integer no);

    List<Task> findTasksByTagNo(Integer tagNo);
}
