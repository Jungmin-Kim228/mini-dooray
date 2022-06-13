package com.nhnacademy.taskapi.dooraytaskapi.entity;

import java.io.Serializable;
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
@Table(name = "task_tag")
public class TaskTag {

    @EmbeddedId
    private Pk pk;

    @MapsId("taskNo")
    @ManyToOne
    @JoinColumn(name = "task_no")
    private Task task;

    @MapsId("tagNo")
    @ManyToOne
    @JoinColumn(name = "tag_no")
    private Tag tag;

    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "task_no")
        private Integer taskNo;

        @Column(name = "tag_no")
        private Integer tagNo;
    }

    @Builder(builderMethodName = "addTaskTag")
    public static TaskTag registerTaskTag(Task task, Tag tag) {
        TaskTag taskTag = new TaskTag();
        taskTag.setTask(task);
        taskTag.setTag(tag);
        taskTag.setPk(new Pk(task.getTaskNo(), tag.getTagNo()));
        return taskTag;
    }
}
