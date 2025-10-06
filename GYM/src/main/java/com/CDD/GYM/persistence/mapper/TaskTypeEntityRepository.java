package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.repository.TaskTypeRepository;
import com.CDD.GYM.persistence.crud.CrudTaskType;
import com.CDD.GYM.persistence.entity.TaskTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public TaskTypeDTO lookTaskById(int id) {
        return this.taskTypeMapper.toTaskTypeDTO(this.crudTaskType.findById(id).orElse(null));
    }

    @Override
    public TaskTypeDTO UpdateTask(Integer id, TaskTypeDTO taskTypeDTO) {
        if(!crudTaskType.existsById(id)){
            return null;
        }
        TaskTypeEntity entity = taskTypeMapper.toTaskTypeEntity(taskTypeDTO);
        entity.setIdType(id);

        return taskTypeMapper.toTaskTypeDTO(crudTaskType.save(entity));
    }

    @Override
    public List<TaskTypeDTO> lookAllTask() {
        return this.taskTypeMapper.toTaskTypeDTOs(this.crudTaskType.findAll());
    }

    @Override
    public void deleteTask(Integer id) {
        this.crudTaskType.deleteById(id);
    }
}
