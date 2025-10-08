package com.CDD.GYM.persistence.mapper;

import com.CDD.GYM.domain.dto.AdminDTO;
import com.CDD.GYM.persistence.entity.AdminEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    // From entity -> dto: accede al id dentro de taskType
    @Mapping(target = "taskTypeId", source = "taskType.idType")
    AdminDTO toAdminDTO(AdminEntity entity);

    List<AdminDTO> toAdminDTOs(Iterable<AdminEntity> entities);

    // From dto -> entity (ignoramos taskType y lo seteamos en el repo)
    @InheritInverseConfiguration
    @Mapping(target = "taskType", ignore = true)
    AdminEntity toAdminEntity(AdminDTO dto);
}
