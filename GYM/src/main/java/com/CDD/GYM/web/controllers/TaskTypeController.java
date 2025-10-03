package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.services.TaskTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gym/api/task_type")
public class TaskTypeController {

    private final TaskTypeService taskTypeService;

    public TaskTypeController(TaskTypeService taskTypeService){
        this.taskTypeService=taskTypeService;
    }

    //http://localhost:8080/gym/api/task_type
    @PostMapping
    public TaskTypeDTO createTaskType(@RequestBody TaskTypeDTO taskTypeDTO){
        return taskTypeService.createTaskType(taskTypeDTO);
    }
    //http://localhost:8080/gym/api/task_type/getTask_type
    @GetMapping("/getTask_type")
    public List<TaskTypeDTO> getTaskType() {

        return this.TaskTypeDTO.getTaskType();

    }
}
