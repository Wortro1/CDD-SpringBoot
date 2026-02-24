package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.AdminDTO;
import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    // Crear un Nuevo Administrador
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        return adminRepository.createAdmin(adminDTO);
    }

    // Obtener la lista de los Administradores
    public List<AdminDTO> lookAllAdmin(){
        return adminRepository.lookAllAdmin();
    }

    // Obtener Administrador por ID
    public AdminDTO findAdminById(Integer id) {
        AdminDTO adminDTO = adminRepository.getAdminById(id);

        // 2. Lógica de Negocio: Si el usuario es null, lanzamos una excepción (error 404).
        if (adminDTO == null) {
            throw new RuntimeException("Usuario externo no encontrado con ID: " + id);
        }

        return adminDTO;
    }


    // Actualizar Administrador
    public AdminDTO updateAdmin(int id, AdminDTO adminDTO) {return adminRepository.updateAdmin(id, adminDTO);
    }

    // Eliminar Administrador
    public void deleteAdmin(int id) {
        adminRepository.deleteAdmin(id);
    }

    //Obtiene la lista completa de todos los usuarios del sistema
    public List<UsuarioExternoDTO> findAllUsers() {

        // Llama al repositorio para obtener la lista de DTOs mapeados.
        return adminRepository.getAllUsers();
    }

    // Crear un nuevo usuario externo desde el Admin
    public UsuarioExternoDTO createUsuarioExterno(UsuarioExternoDTO usuarioExternoDTO) {
        return adminRepository.createUsuarioExterno(usuarioExternoDTO);
    }
}



