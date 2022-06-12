package com.nhnacademy.taskapi.dooraytaskapi.repository.custom;

import com.nhnacademy.taskapi.dooraytaskapi.domain.MilestoneDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MilestoneRepositoryCustom {

    List<MilestoneDto> getMilestoneByProjectNo(Integer no);
}
