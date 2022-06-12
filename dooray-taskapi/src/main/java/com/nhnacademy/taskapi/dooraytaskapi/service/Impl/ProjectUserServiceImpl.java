package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.ProjectUserDto;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectUserRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.ProjectUserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserRepository projectUserRepository;

    @Override
    public List<ProjectUserDto> getProjectUserByProjectNo(Integer no) {
        return projectUserRepository.getProjectUserByProjectNo(no);
    }
}
