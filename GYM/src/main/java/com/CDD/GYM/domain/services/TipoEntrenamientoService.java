package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO; // ✅ CORREGIDO: El DTO ahora se llama correctamente
import com.CDD.GYM.domain.repository.TipoEntrenamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEntrenamientoService {

    private final TipoEntrenamientoRepository tipoEntrenamientoRepository;

    public TipoEntrenamientoService(TipoEntrenamientoRepository tipoEntrenamientoRepository) {
        this.tipoEntrenamientoRepository = tipoEntrenamientoRepository;
    }

    // 2. OBTENER TODOS
    public List<TipoEntrenamientoDTO> getAllTiposEntrenamiento() {
        return tipoEntrenamientoRepository.getAllTiposEntrenamiento();
    }

    // 3. OBTENER POR ID
    public TipoEntrenamientoDTO getTipoEntrenamientoById(int idTipo) {
        return tipoEntrenamientoRepository.getTipoEntrenamientoById(idTipo);
    }

    public TipoEntrenamientoDTO createTipoEntrenamiento(TipoEntrenamientoDTO tipoEntrenamientoDTO) {
        return tipoEntrenamientoRepository.createTipoEntrenamiento(tipoEntrenamientoDTO);
    }

    // 4. ACTUALIZAR
    public TipoEntrenamientoDTO updateTipoEntrenamiento(Integer idTipo, TipoEntrenamientoDTO tipoEntrenamientoDTO) {
        return tipoEntrenamientoRepository.updateTipoEntrenamiento(idTipo, tipoEntrenamientoDTO);
    }

    // 5. ELIMINAR
    public void deleteTipoEntrenamiento(Integer idTipo) {
        tipoEntrenamientoRepository.deleteTipoEntrenamiento(idTipo);
    }
}
