package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import java.util.List;

public interface ProjectUserService {

    List<ProjectUserDto> getProjectUserByProjectNo(Integer no);
}
