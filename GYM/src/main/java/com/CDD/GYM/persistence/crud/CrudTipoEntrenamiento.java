package com.CDD.GYM.persistence.crud;

import com.CDD.GYM.persistence.entity.TipoEntrenamientoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudTipoEntrenamiento  extends CrudRepository<TipoEntrenamientoEntity, Integer> {

}
