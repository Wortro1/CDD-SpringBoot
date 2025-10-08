package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.AdminDTO;

import java.util.List;

public interface AdminRepository {

    // Crear un nuevo Administrador
    AdminDTO createAdmin(AdminDTO adminDTO);

    // Listar Todos los Administradores
    List<AdminDTO> lookAllAdmin();

    // Actualizar Administrador Existente
    AdminDTO updateAdmin(Integer id, AdminDTO adminDTO);

    // Eliminar Admin por ID
    void deleteAdmin(Integer id);
}
