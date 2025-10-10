package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.AdminDTO;
import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.repository.AdminRepository;
import com.CDD.GYM.persistence.crud.CrudAdmin;
import com.CDD.GYM.persistence.crud.CrudTaskType;
import com.CDD.GYM.persistence.entity.AdminEntity;
import com.CDD.GYM.persistence.entity.TaskTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminEntityRepository implements AdminRepository {

    private final CrudAdmin crudAdmin;
    private final CrudTaskType crudTaskType;
    private final AdminMapper adminMapper;

    public AdminEntityRepository(CrudAdmin crudAdmin, CrudTaskType crudTaskType, AdminMapper adminMapper) {
        this.crudAdmin = crudAdmin;
        this.crudTaskType = crudTaskType;
        this.adminMapper = adminMapper;
    }

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        AdminEntity entity = adminMapper.toAdminEntity(adminDTO);

        if (adminDTO.getTaskTypeId() != null) {
            TaskTypeEntity taskType = crudTaskType.findById(adminDTO.getTaskTypeId())
                    .orElseThrow(() -> new RuntimeException("Tipo de tarea no encontrado"));
            entity.setTaskType(taskType);
        }

        AdminEntity saved = crudAdmin.save(entity);
        return adminMapper.toAdminDTO(saved);
    }

    @Override
    public List<AdminDTO> lookAllAdmin() {
        return adminMapper.toAdminDTOs(crudAdmin.findAll());
    }

    @Override
    public AdminDTO updateAdmin(Integer id, AdminDTO adminDTO) {
        if (!crudAdmin.existsById(id)) {
            return null;
        }
        AdminEntity entity = adminMapper.toAdminEntity(adminDTO);
        entity.setId(id);
        return adminMapper.toAdminDTO(crudAdmin.save(entity));
    }

    @Override
    public void deleteAdmin(Integer id) {
        crudAdmin.deleteById(id);
    }

    @Override
    public List<UsuarioExternoDTO> getAllUsers() {
        return List.of();
    }

}
