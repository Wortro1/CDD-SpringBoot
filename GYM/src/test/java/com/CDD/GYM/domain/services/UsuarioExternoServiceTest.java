package com.CDD.GYM.domain.services;

import com.CDD.GYM.domain.dto.UsuarioExternoDTO;
import com.CDD.GYM.domain.repository.UsuarioExternoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UsuarioExternoServiceTest {

    @Mock
    UsuarioExternoRepository usuarioExternoRepository;

    @InjectMocks
    UsuarioExternoService usuarioExternoService;

    private static final Integer TEST_ID = 1;
    private UsuarioExternoDTO testDTO;

    @BeforeEach
    void setUp() {
        testDTO = new UsuarioExternoDTO(
                TEST_ID, "Ana", "Mendoza", "3001234567", "CC", "1000",
                LocalDate.of(1990, 1, 1), true, true
        );

    }
    //PRUEBA CREATE
    @Test
    void createUsuarioExterno_Success() {

        when(usuarioExternoRepository.createUsuarioExterno(testDTO)).thenReturn(testDTO);
        UsuarioExternoDTO result = usuarioExternoService.createUsuarioExterno(testDTO);

        assertNotNull(result, "El resultado no debe ser nulo.");
        assertEquals("Ana", result.nombre(), "El nombre debe coincidir.");
        verify(usuarioExternoRepository, times(1)).createUsuarioExterno(testDTO);
    }
    //PRUEBAS DE UPDATE
    @Test
    void updateUsuarioExterno_Success() {
        UsuarioExternoDTO updatedDTO = new UsuarioExternoDTO(
                TEST_ID, "Ana", "Mendoza", "3009999999", "CC", "1000",
                LocalDate.of(1990, 1, 1), false, true
        );
        when(usuarioExternoRepository.updateUsuarioExterno(TEST_ID, updatedDTO)).thenReturn(updatedDTO);
        UsuarioExternoDTO result = usuarioExternoService.updateUsuarioExterno(TEST_ID, updatedDTO);

        assertNotNull(result);
        assertEquals("3009999999", result.telefono(), "El teléfono debe reflejar el cambio.");
        verify(usuarioExternoRepository, times(1)).updateUsuarioExterno(TEST_ID, updatedDTO);
    }

    // PRUEBAS DE DELETE

    @Test
    void deleteUsuarioExterno_Success() {
        usuarioExternoService.deleteUsuarioExterno(TEST_ID);
        verify(usuarioExternoRepository, times(1)).deleteUsuarioExterno(TEST_ID);
    }
    // Test 1: Caso Exitoso (Usuario Encontrado)
    @Test
    void findUserById_ShouldReturnUserWhenFound() {
        // ARRANGE
        // Definimos el comportamiento del mock: Cuando se llama al repositorio con ID 1, devuelve el testDTO
        when(usuarioExternoRepository.getUsuarioExternoById(TEST_ID)).thenReturn(testDTO);

        // ACT
        UsuarioExternoDTO result = usuarioExternoService.findUserById(TEST_ID);

        // ASSERT
        assertNotNull(result, "El resultado no debe ser null.");
        assertEquals(testDTO.nombre(), result.nombre(), "El nombre del usuario debe coincidir.");
        // Verificamos que el repositorio fue llamado una vez con el ID correcto.
        verify(usuarioExternoRepository, times(1)).getUsuarioExternoById(TEST_ID);
    }

    // Test 2: Caso Fallido (Usuario NO Encontrado -> Debe lanzar excepción)
    @Test
    void findUserById_ShouldThrowRuntimeExceptionWhenNotFound() {
        // ARRANGE
        Integer nonExistentId = 99;

        // Definimos el comportamiento del mock: Cuando se llama al repositorio con ID 99, devuelve null.
        when(usuarioExternoRepository.getUsuarioExternoById(nonExistentId)).thenReturn(null);

        // ACT & ASSERT
        // Verificamos que al ejecutar el método, se lanza la RuntimeException que programamos en el servicio.
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> usuarioExternoService.findUserById(nonExistentId),
                "Se esperaba una RuntimeException cuando el usuario no se encuentra."
        );

        // Verificamos el mensaje de la excepción.
        assertTrue(exception.getMessage().contains("Usuario externo no encontrado con ID: " + nonExistentId));

        // Verificamos que el repositorio fue llamado.
        verify(usuarioExternoRepository, times(1)).getUsuarioExternoById(nonExistentId);
    }
}

