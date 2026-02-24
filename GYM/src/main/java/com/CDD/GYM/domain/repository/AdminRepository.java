package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.AdminDTO;
import com.CDD.GYM.domain.dto.UsuarioExternoDTO;


import java.util.List;

public interface AdminRepository {

    // Crear un nuevo Administrador
    AdminDTO createAdmin(AdminDTO adminDTO);

    // Listar Todos los Administradores
    List<AdminDTO> lookAllAdmin();

    // Ver Admiinistrador Por ID
    AdminDTO getAdminById(Integer id);

    // Actualizar Administrador Existente
    AdminDTO updateAdmin(Integer id, AdminDTO adminDTO);

    // Eliminar Admin por ID
    void deleteAdmin(Integer id);

    List<UsuarioExternoDTO> getAllUsers();

    // Crear un nuevo usuario externo desde el Admin
    UsuarioExternoDTO createUsuarioExterno(UsuarioExternoDTO usuarioExternoDTO);

}
