package com.nhnacademy.taskapi.dooraytaskapi.controller;

import com.nhnacademy.taskapi.dooraytaskapi.domain.DeleteRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneModifyRequest;
import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneRegisterRequest;
import com.nhnacademy.taskapi.dooraytaskapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/milestone")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/projectNo/{projectNo}")
    public List<MilestoneDto> getMilestoneByProjectNo(@PathVariable("projectNo") Integer no) {
        return milestoneService.getMilestoneByProjectNo(no);
    }

    @PostMapping("/register")
    public String registerMilestone(@RequestBody MilestoneRegisterRequest request) {
        milestoneService.registerMilestone(request);
        return "milestone register success";
    }

    @PostMapping("/modify")
    public Integer modifyMilestone(@RequestBody MilestoneModifyRequest request) {
        return milestoneService.modifyMilestone(request);
    }

    @PostMapping("/delete")
    public Integer deleteMilestone(@RequestBody DeleteRequest request) {
        return milestoneService.deleteMilestone(request.getNo());
    }

    @GetMapping("/taskNo/{taskNo}")
    public MilestoneDto getMilestoneDtoByTaskNo(@PathVariable("taskNo") Integer taskNo) {
        return milestoneService.getMilestoneDtoByTaskNo(taskNo);
    }
}
