package com.CDD.GYM.persistence.mapper;


import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.persistence.entity.TaskTypeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskTypeMapper {

    @Mapping(target = "task_description", source = "taskDescription")
    @Mapping(target ="id_task",source = "idType")
    TaskTypeDTO toTaskTypeDTO(TaskTypeEntity entity);

    List<TaskTypeDTO> toTaskTypeDTOs(Iterable <TaskTypeEntity> entities);

    @InheritInverseConfiguration
    TaskTypeEntity toTaskTypeEntity(TaskTypeDTO dto);
}
