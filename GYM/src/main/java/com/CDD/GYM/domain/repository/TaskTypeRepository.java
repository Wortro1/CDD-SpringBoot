package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.TaskTypeDTO;

import java.util.List;

public interface TaskTypeRepository {

 TaskTypeDTO createTaskType(TaskTypeDTO taskTypeDTO);
 List<TaskTypeDTO> getTaskType();

}
