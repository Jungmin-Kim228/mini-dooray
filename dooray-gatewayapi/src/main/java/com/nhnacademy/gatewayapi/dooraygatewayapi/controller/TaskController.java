package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.MilestoneService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TagService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TaskService;
import java.util.List;
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
    public String taskRegister(@ModelAttribute TaskRegisterRequest request, Model model) {

        model.addAttribute("milestone",request.getMilestoneNo());
        model.addAttribute("projectNo", request.getProjectNo());
        model.addAttribute("taskRegistrant", request.getTaskRegistrant());
        model.addAttribute("tagList",request.getTagNoList());
        return "home/home";
    }
}
