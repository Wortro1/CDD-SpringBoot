package com.CDD.GYM.persistence.crud;

import com.CDD.GYM.persistence.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudAdmin extends CrudRepository<AdminEntity, Integer>{

}
