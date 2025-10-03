package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.repository.TaskTypeRepository;
import com.CDD.GYM.persistence.crud.CrudTaskType;
import com.CDD.GYM.persistence.entity.TaskTypeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TaskTypeEntityRepository implements TaskTypeRepository {

    private final CrudTaskType crudTaskType;
    private final TaskTypeMapper taskTypeMapper;

    public TaskTypeEntityRepository (CrudTaskType crudTaskType,TaskTypeMapper taskTypeMapper){
        this.crudTaskType=crudTaskType;
        this.taskTypeMapper=taskTypeMapper;
    }

    @Override
    public TaskTypeDTO createTaskType(TaskTypeDTO taskTypeDTO) {
        TaskTypeEntity entity = taskTypeMapper.toTaskTypeEntity(taskTypeDTO);
        return taskTypeMapper.toTaskTypeDTO(crudTaskType.save(entity));
    }

    @Override
    public List<TaskTypeDTO> getTaskType() {

        return this.TaskTypeMapper.toTaskTypeDTO(this.crudTaskType.findAll());

    }

}
