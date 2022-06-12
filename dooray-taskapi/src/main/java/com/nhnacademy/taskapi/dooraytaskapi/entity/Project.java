package com.nhnacademy.taskapi.dooraytaskapi.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no")
    private Integer projectNo;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "project_status")
    private String projectStatus;

    // here 이하 엔티티들은 프로젝트 삭제 시 같이 삭제되도록 cascade 설정해야함
    @OneToMany(mappedBy = "project")
    private List<ProjectUser> projectUserList = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Milestone> milestoneList = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Tag> tagList = new ArrayList<>();


    @Builder(builderMethodName = "addProject")
    public static Project registerProject(String name, String admin, String status) {
        Project project = new Project();
        project.setProjectName(name);
        project.setAdminId(admin);
        project.setProjectStatus(status);
        return project;
    }
}
