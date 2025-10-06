package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.persistence.entity.TaskTypeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-06T09:47:52-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class TaskTypeMapperImpl implements TaskTypeMapper {

    @Override
    public TaskTypeDTO toTaskTypeDTO(TaskTypeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String task_description = null;
        Integer id_task = null;

        task_description = entity.getTaskDescription();
        id_task = entity.getIdType();

        TaskTypeDTO taskTypeDTO = new TaskTypeDTO( id_task, task_description );

        return taskTypeDTO;
    }

    @Override
    public List<TaskTypeDTO> toTaskTypeDTOs(Iterable<TaskTypeEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TaskTypeDTO> list = new ArrayList<TaskTypeDTO>();
        for ( TaskTypeEntity taskTypeEntity : entities ) {
            list.add( toTaskTypeDTO( taskTypeEntity ) );
        }

        return list;
    }

    @Override
    public TaskTypeEntity toTaskTypeEntity(TaskTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TaskTypeEntity taskTypeEntity = new TaskTypeEntity();

        taskTypeEntity.setTaskDescription( dto.task_description() );
        taskTypeEntity.setIdType( dto.id_task() );

        return taskTypeEntity;
    }
}
