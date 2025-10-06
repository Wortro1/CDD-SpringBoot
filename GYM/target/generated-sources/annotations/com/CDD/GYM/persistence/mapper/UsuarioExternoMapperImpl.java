package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.persistence.entity.UsuarioExternoEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-04T14:40:02-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioExternoMapperImpl implements UsuarioExternoMapper {

    @Override
    public UsuarioExternoDTO toUsuarioExternoDTO(UsuarioExternoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LocalDate fechaDeNacimiento = null;
        Integer id = null;
        String nombre = null;
        String apellido = null;
        String telefono = null;
        String tipoDeDoc = null;
        boolean haciendoMusculacion = false;
        boolean esDeportistaActivo = false;

        fechaDeNacimiento = entity.getFechaNacimiento();
        id = entity.getId();
        nombre = entity.getNombre();
        apellido = entity.getApellido();
        telefono = entity.getTelefono();
        tipoDeDoc = entity.getTipoDeDoc();
        haciendoMusculacion = entity.isHaciendoMusculacion();
        esDeportistaActivo = entity.isEsDeportistaActivo();

        String numberCc = null;

        UsuarioExternoDTO usuarioExternoDTO = new UsuarioExternoDTO( id, nombre, apellido, telefono, tipoDeDoc, numberCc, fechaDeNacimiento, haciendoMusculacion, esDeportistaActivo );

        return usuarioExternoDTO;
    }

    @Override
    public List<UsuarioExternoDTO> toUsuarioExternoDTOs(Iterable<UsuarioExternoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UsuarioExternoDTO> list = new ArrayList<UsuarioExternoDTO>();
        for ( UsuarioExternoEntity usuarioExternoEntity : entities ) {
            list.add( toUsuarioExternoDTO( usuarioExternoEntity ) );
        }

        return list;
    }

    @Override
    public UsuarioExternoEntity toUsuarioExternoEntity(UsuarioExternoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioExternoEntity usuarioExternoEntity = new UsuarioExternoEntity();

        usuarioExternoEntity.setFechaNacimiento( dto.fechaDeNacimiento() );
        if ( dto.id() != null ) {
            usuarioExternoEntity.setId( dto.id() );
        }
        usuarioExternoEntity.setNombre( dto.nombre() );
        usuarioExternoEntity.setApellido( dto.apellido() );
        usuarioExternoEntity.setTelefono( dto.telefono() );
        usuarioExternoEntity.setTipoDeDoc( dto.tipoDeDoc() );
        usuarioExternoEntity.setHaciendoMusculacion( dto.haciendoMusculacion() );
        usuarioExternoEntity.setEsDeportistaActivo( dto.esDeportistaActivo() );

        return usuarioExternoEntity;
    }
}
