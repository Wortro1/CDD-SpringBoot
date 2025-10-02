package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.TaskTypeDTO;

import java.util.List;

public interface TaskTypeRepository {

    public List<TaskTypeDTO> getTaksType();

    public TaskTypeDTO getTaskTypeById(Integer idType);

    public TaskTypeDTO createTaskType(TaskTypeDTO taskTypeDTO);

}
