package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.persistence.entity.UsuarioExternoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioExternoMapper {


    @Mapping(target = "fechaDeNacimiento", source = "fechaNacimiento")
    UsuarioExternoDTO toUsuarioExternoDTO(UsuarioExternoEntity entity);

    List<UsuarioExternoDTO> toUsuarioExternoDTOs(Iterable<UsuarioExternoEntity> entities);

    @InheritInverseConfiguration
    @Mapping(target = "fechaNacimiento", source = "fechaDeNacimiento") //
    UsuarioExternoEntity toUsuarioExternoEntity(UsuarioExternoDTO dto);
}