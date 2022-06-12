package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import java.util.List;

public interface TaskService {

    List<TaskDto> getTaskByProjectNo(Integer no);
}
