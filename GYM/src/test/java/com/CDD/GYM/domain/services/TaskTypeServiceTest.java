package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.TaskTypeDTO;
import com.CDD.GYM.domain.repository.TaskTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskTypeServiceTest {

    // Constante para el ID de referencia en las pruebas
    private static final Integer TEST_ID = 1;

    // Dependencia simulada (Mock)
    @Mock
    TaskTypeRepository taskTypeRepository;

    // Clase real a probar, donde se inyectan los Mocks
    @InjectMocks
    TaskTypeService taskTypeService;

    // Variables de datos de prueba
    TaskTypeDTO testDTO;
    TaskTypeDTO updatedDTO;
    List<TaskTypeDTO> testList;


    @BeforeEach
    void setUp() {
        testDTO = new TaskTypeDTO(
                TEST_ID,
                "Rutina de levantamiento de pesas."
        );
        updatedDTO = new TaskTypeDTO(
                TEST_ID,
                "Rutina de crossfit de alta intensidad." // Descripción modificada
        );
        testList = Arrays.asList(
                testDTO,
                new TaskTypeDTO(2, "Rutina cardiovascular de baja intensidad.")
        );
    }

    @Test
    void createTaskType_Success() {
        // ARRANGE: El repositorio simula guardar y devolver el DTO
        when(taskTypeRepository.createTaskType(testDTO)).thenReturn(testDTO);
        TaskTypeDTO result = taskTypeService.createTaskType(testDTO);
        assertNotNull(result, "El DTO devuelto no debe ser nulo.");
        assertEquals(testDTO.task_description(), result.task_description(), "La descripción debe coincidir.");
        verify(taskTypeRepository, times(1)).createTaskType(testDTO);
    }

    @Test
    void lookTaskById_Success() {
        when(taskTypeRepository.lookTaskById(TEST_ID)).thenReturn(testDTO);
        TaskTypeDTO result = taskTypeService.lookTaskById(TEST_ID);
        assertNotNull(result, "El resultado no debe ser nulo.");
        assertEquals(TEST_ID, result.id_task(), "El ID debe coincidir.");
        verify(taskTypeRepository, times(1)).lookTaskById(TEST_ID);
    }


    @Test
    void lookAllTask_Success() {
        when(taskTypeRepository.lookAllTask()).thenReturn(testList);
        List<TaskTypeDTO> result = taskTypeService.lookAllTask();
        assertNotNull(result, "La lista devuelta no debe ser nula.");
        assertEquals(2, result.size(), "La lista debe contener dos elementos.");
        verify(taskTypeRepository, times(1)).lookAllTask();
    }

    @Test
    void updateTask_Success() {
        when(taskTypeRepository.UpdateTask(TEST_ID, updatedDTO)).thenReturn(updatedDTO);
        TaskTypeDTO result = taskTypeService.UpdateTask(TEST_ID, updatedDTO);
        assertNotNull(result, "El resultado de la actualización no debe ser nulo.");
        assertEquals("Rutina de crossfit de alta intensidad.", result.task_description(), "La descripción debe estar actualizada.");

        verify(taskTypeRepository, times(1)).UpdateTask(TEST_ID, updatedDTO);
    }


    @Test
    void deleteTask_Success() {
        taskTypeService.deleteTask(TEST_ID);
        verify(taskTypeRepository, times(1)).deleteTask(TEST_ID);
    }
}