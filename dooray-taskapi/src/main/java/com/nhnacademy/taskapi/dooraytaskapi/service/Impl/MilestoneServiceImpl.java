package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.exception.MilestoneNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;

    @Override
    public List<MilestoneDto> getMilestoneByProjectNo(Integer no) {
        return milestoneRepository.getMilestoneByProjectNo(no);
    }

    @Override
    public void registerMilestone(MilestoneRegisterRequest request) {
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(ProjectNotFoundException::new);
        Milestone milestone = Milestone.addMilestone()
            .name(request.getMilestoneName())
            .project(project)
            .build();
        milestoneRepository.save(milestone);
    }

    @Override
    public Integer modifyMilestone(MilestoneModifyRequest request) {
        Milestone milestone = milestoneRepository.findById(request.getMilestoneNo()).orElseThrow(
            MilestoneNotFoundException::new);
        milestone.setMilestoneName(request.getMilestoneName());
        milestoneRepository.save(milestone);
        return milestone.getProject().getProjectNo();
    }

    @Override
    public Integer deleteMilestone(Integer request) {
        Milestone milestone = milestoneRepository.findById(request).orElseThrow(MilestoneNotFoundException::new);
        Integer projectNo = milestone.getProject().getProjectNo();
        milestoneRepository.delete(milestone);
        return projectNo;
    }
}
