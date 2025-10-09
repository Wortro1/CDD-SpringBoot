package com.CDD.GYM.domain.repository;

import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import java.util.Optional;
import java.util.List;

// Interfaz del contrato de acceso a datos que usa DTOs
public interface TipoEntrenamientoRepository {

    // Crear un nuevo tipo de entrenamiento
    TipoEntrenamientoDTO createTipoEntrenamiento(TipoEntrenamientoDTO tipoEntrenamientoDTO);

    // Obtener un tipo por ID (Optional para manejo de 404)
    TipoEntrenamientoDTO getTipoEntrenamientoById(Integer idTipo);
    // Obtener todos los tipos
    List<TipoEntrenamientoDTO> getAllTiposEntrenamiento();

    // Actualizar tipo existente
    TipoEntrenamientoDTO updateTipoEntrenamiento(Integer idTipo, TipoEntrenamientoDTO tipoEntrenamientoDTO);

    // Eliminar tipo por ID
    void deleteTipoEntrenamiento(Integer idTipo);
}
