package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.MilestoneAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneRegisterRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneAdapter milestoneAdapter;

    @Override
    public List<MilestoneDto> getMilestoneDtosByProjectNo(Integer projectNo) {
        return milestoneAdapter.getMilestoneDtosByProjectNo(projectNo);
    }

    @Override
    public void registerMilestone(MilestoneRegisterRequest request) {
        milestoneAdapter.registerMilestone(request);
    }

    @Override
    public Integer modifyMilestone(MilestoneModifyRequest request) {
        return milestoneAdapter.modifyMilestone(request);
    }

    @Override
    public Integer deleteMilestone(Integer milestoneNo) {
        return milestoneAdapter.deleteMilestone(milestoneNo);
    }

    @Override
    public MilestoneDto getMilestoneDtoByTaskNo(Integer taskNo) {
        return milestoneAdapter.getMilestoneDtoByTaskNoAndProjectNo(taskNo);
    }
}
