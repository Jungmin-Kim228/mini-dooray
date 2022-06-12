package com.nhnacademy.gatewayapi.dooraygatewayapi.service.Impl;

import com.nhnacademy.gatewayapi.dooraygatewayapi.adapter.MilestoneAdapter;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
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
}
