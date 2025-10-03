package com.CDD.GYM.domain.services;


import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService {

    private final TaskTypeRepository taskTypeRepository;

    public TaskTypeService(TaskTypeRepository taskTypeRepository){
        this .taskTypeRepository=taskTypeRepository;
    }

    //crear tipo de tarea
    public TaskTypeDTO createTaskType(TaskTypeDTO taskTypeDTO){
        return this.taskTypeRepository.createTaskType(taskTypeDTO);
    }

    // listar Todas Las Tareas
    public  List<TaskTypeDTO> getTaskType() {

        return TaskTypeRepository.getTaskType();

    }
}
