package com.CDD.GYM.persistence.crud;

import com.CDD.GYM.persistence.entity.UsuarioExternoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUsuarioExterno  extends CrudRepository<UsuarioExternoEntity, Integer> {
}
