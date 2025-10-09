package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;

public interface UsuarioExternoRepository {

    // Crear un nuevo usuario
    UsuarioExternoDTO createUsuarioExterno(UsuarioExternoDTO usuarioExternoDTO);

    // Actualizar usuario existente
    UsuarioExternoDTO updateUsuarioExterno(Integer id, UsuarioExternoDTO usuarioExternoDTO);

    // Eliminar usuario por ID
    void deleteUsuarioExterno(Integer id);

    UsuarioExternoDTO getUsuarioExternoById(Integer id);
}
