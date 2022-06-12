package com.nhnacademy.taskapi.dooraytaskapi.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project_user")
public class ProjectUser {
    @EmbeddedId
    private Pk pk;

    @MapsId("projectNo")
    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;

    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "user_id")
        private String userId;

        @Column(name = "project_no")
        private Integer projectNo;
    }

    @Builder(builderMethodName = "addProjectUser")
    public static ProjectUser registerProjectUser(String id, Project project) {
        ProjectUser projectUser = new ProjectUser();
        projectUser.setProject(project);
        projectUser.setPk(new Pk(id, project.getProjectNo()));
        return projectUser;
    }
}
