package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.repository.UsuarioExternoRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioExternoService {

    private final UsuarioExternoRepository usuarioExternoRepository;

    public UsuarioExternoService(UsuarioExternoRepository usuarioExternoRepository) {
        this.usuarioExternoRepository = usuarioExternoRepository;
    }

    // Crear usuario externo
    public UsuarioExternoDTO createUsuarioExterno(UsuarioExternoDTO usuarioExternoDTO) {
        return usuarioExternoRepository.createUsuarioExterno(usuarioExternoDTO);
    }

    // Actualizar usuario externo
    public UsuarioExternoDTO updateUsuarioExterno(int id, UsuarioExternoDTO usuarioExternoDTO) {
        return usuarioExternoRepository.updateUsuarioExterno(id, usuarioExternoDTO);
    }

    // Eliminar usuario externo
    public void deleteUsuarioExterno(int id) {
        usuarioExternoRepository.deleteUsuarioExterno(id);
    }


    public UsuarioExternoDTO findUserById(Integer id) {
        UsuarioExternoDTO usuario = usuarioExternoRepository.getUsuarioExternoById(id);

        // 2. Lógica de Negocio: Si el usuario es null, lanzamos una excepción (error 404).
        if (usuario == null) {
            throw new RuntimeException("Usuario externo no encontrado con ID: " + id);
        }

        return usuario;
    }
}

