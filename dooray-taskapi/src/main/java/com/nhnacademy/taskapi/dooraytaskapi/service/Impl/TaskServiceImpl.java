package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.TaskRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Milestone;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Project;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Tag;
import com.nhnacademy.taskapi.dooraytaskapi.entity.Task;
import com.nhnacademy.taskapi.dooraytaskapi.entity.TaskTag;
import com.nhnacademy.taskapi.dooraytaskapi.exception.MilestoneNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.ProjectNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.TagNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.exception.TaskNotFoundException;
import com.nhnacademy.taskapi.dooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TagRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TaskRepository;
import com.nhnacademy.taskapi.dooraytaskapi.repository.TaskTagRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.TaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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

    @Override
    @Transactional
    public Integer modifyTask(TaskModifyRequest request) {
        Task task = taskRepository.findById(request.getTaskNo()).orElseThrow(TaskNotFoundException::new);
        Milestone milestone = milestoneRepository.findById(request.getMilestoneNo()).orElse(null);

        task.setTaskTitle(request.getTaskTitle());
        task.setTaskContent(request.getTaskContent());
        task.setMilestone(milestone);
        taskRepository.save(task);

        List<TaskTag> taskTags = taskTagRepository.findTaskTagsByPk_TaskNo(task.getTaskNo());
        taskTagRepository.deleteAll(taskTags);

        for (Integer tagNo : request.getTagNoList()) {
            Optional<TaskTag>
                findTaskTag = taskTagRepository.findById(new TaskTag.Pk(task.getTaskNo(), tagNo));
            if (findTaskTag.isEmpty()) {
                Tag tag = tagRepository.findById(tagNo).orElseThrow(TagNotFoundException::new);
                TaskTag taskTag = TaskTag.addTaskTag()
                    .task(task)
                    .tag(tag)
                    .build();
                taskTagRepository.save(taskTag);
            }
        }
        return task.getProject().getProjectNo();
    }

    @Override
    @Transactional
    public Integer deleteTask(Integer taskNo) {
        Task task = taskRepository.findById(taskNo).orElseThrow(TaskNotFoundException::new);
        Integer projectNo = task.getProject().getProjectNo();
        taskTagRepository.deleteTaskTagsByPk_TaskNo(taskNo);
        taskRepository.delete(task);
        return projectNo;
    }
}
