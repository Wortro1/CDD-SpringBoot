package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.services.TaskTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //http://localhost:8080/gym/api/task_type/look_task_id/2"
    @GetMapping("/look_task_id/{id}")
    public TaskTypeDTO lookTaskById(@PathVariable int id){
        return taskTypeService.lookTaskById(id);
    }

    //http://localhost:8080/gym/api/task_type/update_task/13
    @PutMapping("/update_task/{id}")
    public TaskTypeDTO updateTask(@PathVariable Integer id,@RequestBody TaskTypeDTO taskTypeDTO){
        return taskTypeService.UpdateTask(id,taskTypeDTO);
    }

    //http://localhost:8080/gym/api/task_type/all_task
    @GetMapping("/all_task")
    public List<TaskTypeDTO> lookAllTask(){
        return this.taskTypeService.lookAllTask();
    }

    //http://localhost:8080/gym/api/task_type/delete_task/10
    @DeleteMapping("/delete_task/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskTypeService.deleteTask(id);
    }


}
