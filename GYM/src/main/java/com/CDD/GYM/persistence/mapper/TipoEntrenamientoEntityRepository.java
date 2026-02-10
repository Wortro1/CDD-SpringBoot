package com.CDD.GYM.persistence.mapper;
import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import com.CDD.GYM.domain.repository.TipoEntrenamientoRepository;
import com.CDD.GYM.persistence.crud.CrudTipoEntrenamiento;
import com.CDD.GYM.persistence.entity.TipoEntrenamientoEntity;
import com.CDD.GYM.persistence.mapper.TipoEntrenamientoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoEntrenamientoEntityRepository implements TipoEntrenamientoRepository {


    final private CrudTipoEntrenamiento crudTipoEntrenamiento;
    final private TipoEntrenamientoMapper mapper;


    public TipoEntrenamientoEntityRepository(CrudTipoEntrenamiento crudTipoEntrenamiento, TipoEntrenamientoMapper mapper) {
        this.crudTipoEntrenamiento = crudTipoEntrenamiento;
        this.mapper = mapper;
    }


    // 1. LISTAR TODOS
    @Override
    public List<TipoEntrenamientoDTO> getAllTiposEntrenamiento() {
        // Implementación: Mapear findAll() de Iterable a List<DTO>.
        return this.mapper.toTipoEntrenamientoDTOs((List<TipoEntrenamientoEntity>) this.crudTipoEntrenamiento.findAll());
    }

    // 2. BUSCAR POR ID
    @Override
    public TipoEntrenamientoDTO getTipoEntrenamientoById(Integer idTipo) {
        // findById devuelve Optional; si no está, devuelve null.
        return this.crudTipoEntrenamiento.findById(idTipo)
                .map(entity -> this.mapper.toTipoEntrenamientoDTO(entity))
                .orElse(null);
    }

    // 3. CREAR
    @Override
    public TipoEntrenamientoDTO createTipoEntrenamiento(TipoEntrenamientoDTO dto) {
        // DTO -> Entity -> Save -> DTO
        TipoEntrenamientoEntity entity = this.mapper.toTipoEntrenamientoEntity(dto);
        return this.mapper.toTipoEntrenamientoDTO(this.crudTipoEntrenamiento.save(entity));
    }

    // 4. ACTUALIZAR
    @Override
    public TipoEntrenamientoDTO updateTipoEntrenamiento(Integer idTipo, TipoEntrenamientoDTO dto) {
        TipoEntrenamientoEntity existingEntity = this.crudTipoEntrenamiento.findById(idTipo).orElse(null);
        if (existingEntity == null) return null;
        TipoEntrenamientoEntity entityToUpdate = this.mapper.toTipoEntrenamientoEntity(dto);
        entityToUpdate.setIdTipoEntrenamiento(idTipo);
        return this.mapper.toTipoEntrenamientoDTO(this.crudTipoEntrenamiento.save(entityToUpdate));
    }

    // 5. ELIMINAR
    @Override
    public void deleteTipoEntrenamiento(Integer idTipo) {
        this.crudTipoEntrenamiento.deleteById(idTipo);
    }
}
