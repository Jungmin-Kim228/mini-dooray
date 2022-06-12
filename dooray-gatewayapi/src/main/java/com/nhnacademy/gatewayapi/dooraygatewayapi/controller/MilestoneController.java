package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/milestoneRegister/{projectNo}")
    public String milestoneRegisterForm(@PathVariable("projectNo") Integer projectNo, Model model) {
        model.addAttribute("projectNo", projectNo);
        return "milestone/milestoneRegisterForm";
    }

    @PostMapping("/milestoneRegister")
    public String milestoneRegister(@ModelAttribute MilestoneRegisterRequest request) {
        milestoneService.registerMilestone(request);
        return "redirect:/project/detail/"+request.getProjectNo();
    }

    @GetMapping("/milestoneModify/{milestoneNo}")
    public String milestoneModifyForm(@PathVariable("milestoneNo") Integer milestoneNo, Model model) {
        model.addAttribute("milestoneNo", milestoneNo);
        return "milestone/milestoneModifyForm";
    }

    @PostMapping("/milestoneModify")
    public String milestoneModify(@ModelAttribute MilestoneModifyRequest request) {
        Integer projectNo = milestoneService.modifyMilestone(request);
        return "redirect:/project/detail/"+projectNo;
    }
}
