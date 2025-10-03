package com.CDD.GYM.persistence.crud;

import com.CDD.GYM.persistence.entity.TaskTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudTaskType extends CrudRepository<TaskTypeEntity,Integer>{

}
