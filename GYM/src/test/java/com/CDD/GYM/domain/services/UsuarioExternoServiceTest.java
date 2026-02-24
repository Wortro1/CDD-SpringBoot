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
        // Corregido: Se eliminó un argumento String extra para cumplir con los 8 requeridos
        testDTO = new UsuarioExternoDTO(
                TEST_ID, "Ana", "Mendoza", "3001234567", "CC",
                LocalDate.of(1990, 1, 1), true, true
        );
    }

    @Test
    void createUsuarioExterno_Success() {
        when(usuarioExternoRepository.createUsuarioExterno(testDTO)).thenReturn(testDTO);
        UsuarioExternoDTO result = usuarioExternoService.createUsuarioExterno(testDTO);

        assertNotNull(result, "El resultado no debe ser nulo.");
        assertEquals("Ana", result.nombre(), "El nombre debe coincidir.");
        verify(usuarioExternoRepository, times(1)).createUsuarioExterno(testDTO);
    }

    @Test
    void updateUsuarioExterno_Success() {
        // Corregido: Se ajustaron los parámetros a 8 para que compile correctamente
        UsuarioExternoDTO updatedDTO = new UsuarioExternoDTO(
                TEST_ID, "Ana", "Mendoza", "3009999999", "CC",
                LocalDate.of(1990, 1, 1), false, true
        );

        when(usuarioExternoRepository.updateUsuarioExterno(TEST_ID, updatedDTO)).thenReturn(updatedDTO);
        UsuarioExternoDTO result = usuarioExternoService.updateUsuarioExterno(TEST_ID, updatedDTO);

        assertNotNull(result);
        assertEquals("3009999999", result.telefono(), "El teléfono debe reflejar el cambio.");
        verify(usuarioExternoRepository, times(1)).updateUsuarioExterno(TEST_ID, updatedDTO);
    }

    @Test
    void deleteUsuarioExterno_Success() {
        usuarioExternoService.deleteUsuarioExterno(TEST_ID);
        verify(usuarioExternoRepository, times(1)).deleteUsuarioExterno(TEST_ID);
    }

    @Test
    void findUserById_ShouldReturnUserWhenFound() {
        when(usuarioExternoRepository.getUsuarioExternoById(TEST_ID)).thenReturn(testDTO);
        UsuarioExternoDTO result = usuarioExternoService.findUserById(TEST_ID);

        assertNotNull(result, "El resultado no debe ser null.");
        assertEquals(testDTO.nombre(), result.nombre(), "El nombre del usuario debe coincidir.");
        verify(usuarioExternoRepository, times(1)).getUsuarioExternoById(TEST_ID);
    }

    @Test
    void findUserById_ShouldThrowRuntimeExceptionWhenNotFound() {
        Integer nonExistentId = 99;
        when(usuarioExternoRepository.getUsuarioExternoById(nonExistentId)).thenReturn(null);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> usuarioExternoService.findUserById(nonExistentId)
        );

        assertTrue(exception.getMessage().contains("Usuario externo no encontrado con ID: " + nonExistentId));
        verify(usuarioExternoRepository, times(1)).getUsuarioExternoById(nonExistentId);
    }
}