package com.nhnacademy.taskapi.dooraytaskapi.service.Impl;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import com.nhnacademy.taskapi.dooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.taskapi.dooraytaskapi.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final MilestoneRepository milestoneRepository;

    @Override
    public List<MilestoneDto> getMilestoneByProjectNo(Integer no) {
        return milestoneRepository.getMilestoneByProjectNo(no);
    }
}
