package com.CDD.GYM.persistence.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity extends PersonaEntity {

    @ManyToOne
    @JoinColumn(name = "id_task_type")
    private TaskTypeEntity taskType;
}