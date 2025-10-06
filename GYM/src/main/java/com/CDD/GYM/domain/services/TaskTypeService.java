package com.CDD.GYM.domain.services;


import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.repository.TaskTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //buscar tarea por id
    public TaskTypeDTO lookTaskById(int id){
        return taskTypeRepository.lookTaskById(id);
    }

    //actualizar tarea
    public TaskTypeDTO UpdateTask(Integer id, TaskTypeDTO taskTypeDTO){
        return taskTypeRepository.UpdateTask(id,taskTypeDTO);
    }

    //listar todas las tareas
    public List<TaskTypeDTO> lookAllTask(){
        return taskTypeRepository.lookAllTask();
    }

    public void deleteTask(Integer id){
        taskTypeRepository.deleteTask(id);
    }
}
