package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.TaskTypeDTO;

import java.util.List;

public interface TaskTypeRepository {

 TaskTypeDTO createTaskType(TaskTypeDTO taskTypeDTO);

 TaskTypeDTO lookTaskById(int id );

 TaskTypeDTO UpdateTask(Integer id,TaskTypeDTO taskTypeDTO);

 List<TaskTypeDTO> lookAllTask();

 void deleteTask(Integer id);

}
