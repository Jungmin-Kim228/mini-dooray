package com.nhnacademy.gatewayapi.dooraygatewayapi.service;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import java.util.List;

public interface TaskService {

    List<TaskDto> getTaskDtosByProjectNo(Integer projectNo);


}
