package com.CDD.GYM.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_type")
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeEntity {

    @Id
    @Column(name = "id_task_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;

    @Column (name = "task_description")
    private String taskDescription;

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
