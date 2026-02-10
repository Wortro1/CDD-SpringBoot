package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import com.CDD.GYM.domain.repository.TipoEntrenamientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TipoEntrenamientoServiceTest {

    private static final Integer TEST_ID = 1;

    @Mock
    TipoEntrenamientoRepository tipoEntrenamientoRepository;

    @InjectMocks
    TipoEntrenamientoService tipoEntrenamientoService;

    TipoEntrenamientoDTO testDTO;
    TipoEntrenamientoDTO updatedDTO;
    List<TipoEntrenamientoDTO> testList;


    @BeforeEach
    void setUp() {
        testDTO = new TipoEntrenamientoDTO(
                TEST_ID,
                "Cardio",
                "Rutina de ejercicios cardiovasculares."
        );

        updatedDTO = new TipoEntrenamientoDTO(
                TEST_ID,
                "Cardio Intenso",
                "Rutina HIIT de alta intensidad."
        );
        testList = Arrays.asList(
                testDTO,
                new TipoEntrenamientoDTO(2, "Pesas", "Entrenamiento de fuerza.")
        );
    }

    @Test
    void getAllTiposEntrenamiento_Success() {
        when(tipoEntrenamientoRepository.getAllTiposEntrenamiento()).thenReturn(testList);
        List<TipoEntrenamientoDTO> result = tipoEntrenamientoService.getAllTiposEntrenamiento();

        assertNotNull(result, "La lista devuelta no debe ser nula.");
        assertEquals(2, result.size(), "La lista debe contener dos elementos.");
        verify(tipoEntrenamientoRepository, times(1)).getAllTiposEntrenamiento();
    }

    @Test
    void getTipoEntrenamientoById_Success() {
        when(tipoEntrenamientoRepository.getTipoEntrenamientoById(TEST_ID)).thenReturn(testDTO);

        TipoEntrenamientoDTO result = tipoEntrenamientoService.getTipoEntrenamientoById(TEST_ID);

        assertNotNull(result, "El resultado no debe ser nulo.");
        assertEquals(TEST_ID, result.id_tipo_entrenamiento(), "El ID debe coincidir.");
        verify(tipoEntrenamientoRepository, times(1)).getTipoEntrenamientoById(TEST_ID);
    }

    @Test
    void getTipoEntrenamientoById_NotFound() {
        when(tipoEntrenamientoRepository.getTipoEntrenamientoById(TEST_ID)).thenReturn(null);
        TipoEntrenamientoDTO result = tipoEntrenamientoService.getTipoEntrenamientoById(TEST_ID);
        assertNull(result, "Si no se encuentra el recurso, debe devolver null.");
        verify(tipoEntrenamientoRepository, times(1)).getTipoEntrenamientoById(TEST_ID);
    }


    @Test
    void createTipoEntrenamiento_Success() {

        when(tipoEntrenamientoRepository.createTipoEntrenamiento(testDTO)).thenReturn(testDTO);
        TipoEntrenamientoDTO result = tipoEntrenamientoService.createTipoEntrenamiento(testDTO);
        assertNotNull(result, "El DTO devuelto no debe ser nulo.");
        assertEquals("Cardio", result.nombre_tipo_entrenamiento(), "El nombre debe coincidir.");
        verify(tipoEntrenamientoRepository, times(1)).createTipoEntrenamiento(testDTO);
    }

    @Test
    void updateTipoEntrenamiento_Success() {
        when(tipoEntrenamientoRepository.updateTipoEntrenamiento(TEST_ID, updatedDTO)).thenReturn(updatedDTO);
        TipoEntrenamientoDTO result = tipoEntrenamientoService.updateTipoEntrenamiento(TEST_ID, updatedDTO);
        assertNotNull(result, "El resultado de la actualización no debe ser nulo.");
        assertEquals("Cardio Intenso", result.nombre_tipo_entrenamiento(), "El nombre debe estar actualizado.");
        verify(tipoEntrenamientoRepository, times(1)).updateTipoEntrenamiento(TEST_ID, updatedDTO);
    }



    @Test
    void deleteTipoEntrenamiento_Success() {
        tipoEntrenamientoService.deleteTipoEntrenamiento(TEST_ID);
        verify(tipoEntrenamientoRepository, times(1)).deleteTipoEntrenamiento(TEST_ID);
    }
}