package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Task;
import com.nhnacademy.taskapi.dooraytaskapi.exception.MilestoneNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TaskRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<MilestoneDto> getMilestoneByProjectNo(Integer no) {
        return milestoneRepository.getMilestonesByProject_ProjectNo(no);
    }

    @Override
    @Transactional
    public void registerMilestone(MilestoneRegisterRequest request) {
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(ProjectNotFoundException::new);
        Milestone milestone = Milestone.addMilestone()
            .name(request.getMilestoneName())
            .project(project)
            .build();
        milestoneRepository.save(milestone);
    }

    @Override
    @Transactional
    public Integer modifyMilestone(MilestoneModifyRequest request) {
        Milestone milestone = milestoneRepository.findById(request.getMilestoneNo()).orElseThrow(
            MilestoneNotFoundException::new);
        milestone.setMilestoneName(request.getMilestoneName());
        milestoneRepository.save(milestone);
        return milestone.getProject().getProjectNo();
    }

    @Override
    @Transactional
    public Integer deleteMilestone(Integer milestoneNo) {
        Milestone milestone = milestoneRepository.findById(milestoneNo).orElseThrow(MilestoneNotFoundException::new);
        Integer projectNo = milestone.getProject().getProjectNo();

        List<Task> tasks = taskRepository.findTasksByMilestone_MilestoneNo(milestoneNo);
        for (Task task : tasks) {
            task.setMilestone(null);
        }

        milestoneRepository.delete(milestone);
        return projectNo;
    }

    @Override
    public MilestoneDto getMilestoneDtoByTaskNo(Integer taskNo) {
        return milestoneRepository.getMilestoneDtoByTaskNo(taskNo);
    }
}
