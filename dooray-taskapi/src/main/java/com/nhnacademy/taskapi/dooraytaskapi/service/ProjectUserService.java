package com.nhnacademy.taskapi.dooraytaskapi.service;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserAddRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDeleteRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import java.util.List;

public interface ProjectUserService {

    List<ProjectUserDto> getProjectUserByProjectNo(Integer no);

    void addProjectUser(ProjectUserAddRequest request);

    void deleteProjectUser(ProjectUserDeleteRequest request);
}
