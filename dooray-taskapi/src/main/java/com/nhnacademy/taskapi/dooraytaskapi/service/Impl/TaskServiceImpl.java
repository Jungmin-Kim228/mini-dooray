package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Tag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Task;
import com.nhnacademy.taskapi.dooraytaskapi.entity.TaskTag;
import com.nhnacademy.taskapi.dooraytaskapi.exception.MilestoneNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.TagNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TagRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TaskRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TaskTagRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.TaskService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;
    private final MilestoneRepository milestoneRepository;
    private final TaskTagRepository taskTagRepository;

    @Override
    public List<TaskDto> getTaskByProjectNo(Integer no) {
        return taskRepository.getTaskByProjectNo(no);
    }

    @Override
    public void registerTask(TaskRegisterRequest request) {
        Project project = projectRepository.findById(request.getProjectNo()).orElseThrow(
            ProjectNotFoundException::new);
        Milestone milestone = null;
        if (request.getMilestoneNo() != 0) {
            milestone = milestoneRepository.findById(request.getMilestoneNo()).orElseThrow(MilestoneNotFoundException::new);
        }
        Task task = Task.addTask()
            .title(request.getTaskTitle())
            .content(request.getTaskContent())
            .registrant(request.getTaskRegistrant())
            .project(project)
            .milestone(milestone)
            .build();
        taskRepository.save(task);

        for (Integer tagNo : request.getTagNoList()) {
            Tag tag = tagRepository.findById(tagNo).orElseThrow(TagNotFoundException::new);
            TaskTag taskTag = TaskTag.addTaskTag()
                .task(task)
                .tag(tag)
                .build();
            taskTagRepository.save(taskTag);
        }
    }

    @Override
    public TaskDto getTaskDtoByTaskNo(Integer no) {
        return taskRepository.getTaskDtoByTaskNo(no);
    }
}
