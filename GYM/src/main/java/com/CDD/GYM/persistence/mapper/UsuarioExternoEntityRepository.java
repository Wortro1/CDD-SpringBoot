package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.repository.UsuarioExternoRepository;
import com.CDD.GYM.persistence.crud.CrudUsuarioExterno;
import com.CDD.GYM.persistence.entity.UsuarioExternoEntity;
import com.CDD.GYM.persistence.mapper.UsuarioExternoMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioExternoEntityRepository implements UsuarioExternoRepository {

    private final CrudUsuarioExterno crudUsuarioExterno;
    private final UsuarioExternoMapper usuarioExternoMapper;

    public UsuarioExternoEntityRepository(CrudUsuarioExterno crudUsuarioExterno,
                                          UsuarioExternoMapper usuarioExternoMapper) {
        this.crudUsuarioExterno = crudUsuarioExterno;
        this.usuarioExternoMapper = usuarioExternoMapper;
    }

    @Override
    public UsuarioExternoDTO createUsuarioExterno(UsuarioExternoDTO usuarioExternoDTO) {
        UsuarioExternoEntity entity = usuarioExternoMapper.toUsuarioExternoEntity(usuarioExternoDTO);
        return usuarioExternoMapper.toUsuarioExternoDTO(crudUsuarioExterno.save(entity));
    }

    @Override
    public UsuarioExternoDTO updateUsuarioExterno(Integer id, UsuarioExternoDTO usuarioExternoDTO) {
        if (!crudUsuarioExterno.existsById(id)) {
            return null;
        }
        UsuarioExternoEntity entity = usuarioExternoMapper.toUsuarioExternoEntity(usuarioExternoDTO);
        entity.setId(id);
        return usuarioExternoMapper.toUsuarioExternoDTO(crudUsuarioExterno.save(entity));
    }

    @Override
    public void deleteUsuarioExterno(Integer id) {
        crudUsuarioExterno.deleteById(id);
    }

    @Override
    public UsuarioExternoDTO getUsuarioExternoById(Integer id) {

        //    Esto devuelve un Optional<UsuarioExternoEntity>.
        return crudUsuarioExterno.findById(id)
                // 2. Si el Optional contiene un resultado (.map), usa el mapper para convertir
                //    la Entity al DTO.
                .map(entity -> usuarioExternoMapper.toUsuarioExternoDTO(entity))
                // 3. Si no se encuentra el usuario (Optional está vacío), retorna null.
                .orElse(null);
    }
}
