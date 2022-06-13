package com.nhnacademy.taskapi.dooraytaskapi.repository;

import com.nhnacademy.taskapi.dooraytaskapi.entity.Task;
import com.nhnacademy.taskapi.dooraytaskapi.repository.custom.TaskRepositoryCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, TaskRepositoryCustom {

    List<Task> findTasksByMilestone_MilestoneNo(Integer milestoneNo);

}
