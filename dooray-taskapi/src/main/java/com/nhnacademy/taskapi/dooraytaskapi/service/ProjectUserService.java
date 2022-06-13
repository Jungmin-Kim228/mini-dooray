package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserAddRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.UserIdOnlyDto;
import java.util.List;

public interface ProjectUserService {

    List<ProjectUserDto> getProjectUserByProjectNo(Integer no);

    List<UserIdOnlyDto> getProjectUserIdByProjectNo(Integer no);

    void addProjectUser(ProjectUserAddRequest request);
}
