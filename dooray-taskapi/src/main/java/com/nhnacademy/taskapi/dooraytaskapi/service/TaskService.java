package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskRegisterRequest;
import java.util.List;

public interface TaskService {

    List<TaskDto> getTaskByProjectNo(Integer no);

    void registerTask(TaskRegisterRequest request);

    TaskDto getTaskDtoByTaskNo(Integer no);

    Integer modifyTask(TaskModifyRequest request);

    Integer deleteTask(Integer taskNo);
}
