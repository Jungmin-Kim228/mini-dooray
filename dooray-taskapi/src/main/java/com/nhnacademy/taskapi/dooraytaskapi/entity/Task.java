package com.nhnacademy.taskapi.dooraytaskapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_no")
    private Integer taskNo;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "task_registrant")
    private String taskRegistrant;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "milestone_no")
    private Milestone milestone;

    @Builder(builderMethodName = "addTask")
    public static Task registerTask(String title, String content, String registrant, Project project, Milestone milestone) {
        Task task = new Task();
        task.setTaskTitle(title);
        task.setTaskContent(content);
        task.setTaskRegistrant(registrant);
        task.setProject(project);
        task.setMilestone(milestone);
        return task;
    }
}
