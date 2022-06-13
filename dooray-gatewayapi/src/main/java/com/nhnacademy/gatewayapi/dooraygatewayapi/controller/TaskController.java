package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.MilestoneService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TagService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TaskService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final MilestoneService milestoneService;
    private final TagService tagService;

    @GetMapping("/task/register/{projectNo}")
    public String taskRegisterForm(@PathVariable("projectNo") Integer projectNo,
                               Authentication authentication, Model model) {
        String userName = ((User) authentication.getPrincipal()).getUsername();
        List<MilestoneDto> milestones = milestoneService.getMilestoneDtosByProjectNo(projectNo);
        List<TagDto> tags = tagService.getTagDtosByProjectNo(projectNo);

        model.addAttribute("milestones", milestones);
        model.addAttribute("tags", tags);
        model.addAttribute("projectNo", projectNo);
        model.addAttribute("userName", userName);
        model.addAttribute("item", new TaskRegisterRequest());
        return "task/taskRegisterForm";
    }

    @PostMapping("/task/register")
    public String taskRegister(@ModelAttribute TaskRegisterRequest request) {
        taskService.registerTask(request);
        return "redirect:/project/detail/"+request.getProjectNo();
    }

    @GetMapping("/task/detail/{taskNo}/{projectNo}")
    public String taskDetail(@PathVariable("taskNo") Integer taskNo,
                             @PathVariable("projectNo") Integer projectNo, Model model) {
        TaskDto taskDto = taskService.getTaskDtoByTaskNo(taskNo);
        MilestoneDto milestoneDto = milestoneService.getMilestoneDtoByTaskNo(taskNo);
        List<TagDto> tagDtos = tagService.getTagDtosByTaskNo(taskNo);

        model.addAttribute("projectNo", projectNo);
        model.addAttribute("task", taskDto);
        model.addAttribute("milestone", milestoneDto);
        model.addAttribute("tags", tagDtos);
        return "task/taskDetail";
    }

    @GetMapping("/task/modify/{taskNo}/{projectNo}")
    public String taskModifyForm(@PathVariable("taskNo") Integer taskNo,
                             @PathVariable("projectNo") Integer projectNo,
                             Authentication authentication, Model model) {
        String userName = ((User) authentication.getPrincipal()).getUsername();
        TaskDto task = taskService.getTaskDtoByTaskNo(taskNo);

        if (!userName.equals(task.getTaskRegistrant())) {
            return "redirect:/task/detail/"+taskNo+"/"+projectNo;
        }

        List<MilestoneDto> milestones = milestoneService.getMilestoneDtosByProjectNo(projectNo);
        List<TagDto> tags = tagService.getTagDtosByProjectNo(projectNo);
        model.addAttribute("taskNo", taskNo);
        model.addAttribute("milestones", milestones);
        model.addAttribute("tags", tags);
        model.addAttribute("item", new TaskModifyRequest());
        return "task/taskModifyForm";
    }

    @PostMapping("/task/modify")
    public String taskModify(@ModelAttribute TaskModifyRequest request) {
        Integer projectNo = taskService.modifyTask(request);
        return "redirect:/task/detail/"+request.getTaskNo()+"/"+projectNo;
    }
}
