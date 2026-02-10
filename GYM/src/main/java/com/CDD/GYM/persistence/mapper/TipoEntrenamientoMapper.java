package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import com.CDD.GYM.persistence.entity.TipoEntrenamientoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEntrenamientoMapper {

    // Mapeo de Entity (source) a DTO (target)
    @Mapping(target = "id_tipo_entrenamiento", source = "idTipoEntrenamiento")
    @Mapping(target = "nombre_tipo_entrenamiento", source = "nombreTipoEntrenamiento")
    @Mapping(target = "descripcion_tipo_entrenamiento", source = "descripcionTipoEntrenamiento")
    TipoEntrenamientoDTO toTipoEntrenamientoDTO(TipoEntrenamientoEntity entity);

    List<TipoEntrenamientoDTO> toTipoEntrenamientoDTOs(Iterable<TipoEntrenamientoEntity> entities);

    // Mapeo Inverso (DTO a Entity)
    @InheritInverseConfiguration
    @Mapping(target = "idTipoEntrenamiento", source = "id_tipo_entrenamiento")
    @Mapping(target = "nombreTipoEntrenamiento", source = "nombre_tipo_entrenamiento")
    @Mapping(target = "descripcionTipoEntrenamiento", source = "descripcion_tipo_entrenamiento")
    TipoEntrenamientoEntity toTipoEntrenamientoEntity(TipoEntrenamientoDTO dto);
}
