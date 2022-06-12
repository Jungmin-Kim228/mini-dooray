package com.nhnacademy.gatewayapi.dooraygatewayapi.adapter;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneModifyRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneRegisterRequest;
import java.util.List;

public interface MilestoneAdapter {

    List<MilestoneDto> getMilestoneDtosByProjectNo(Integer projectNo);

    void registerMilestone(MilestoneRegisterRequest request);

    Integer modifyMilestone(MilestoneModifyRequest request);

    Integer deleteMilestone(Integer milestoneNo);
}
