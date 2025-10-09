package com.CDD.GYM.web.controllers;

import com.CDD.GYM.domain.dto.TipoEntrenamientoDTO;
import com.CDD.GYM.domain.services.TipoEntrenamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/api/tipos-entrenamiento")
public class TipoEntrenamientoController {

    private final TipoEntrenamientoService tipoEntrenamientoService;
    public TipoEntrenamientoController(TipoEntrenamientoService tipoEntrenamientoService) {
        this.tipoEntrenamientoService = tipoEntrenamientoService;
    }

    // 1. LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<TipoEntrenamientoDTO>> getAllTiposEntrenamiento() {
        List<TipoEntrenamientoDTO> tipos = tipoEntrenamientoService.getAllTiposEntrenamiento();
        if (tipos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // 2. BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoEntrenamientoDTO> getTipoEntrenamientoById(@PathVariable("id") Integer idTipo) {
        TipoEntrenamientoDTO tipo = tipoEntrenamientoService.getTipoEntrenamientoById(idTipo);

        if (tipo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipo, HttpStatus.OK);
    }

    // 3. CREAR (POST /tipos-entrenamiento)
    @PostMapping
    public ResponseEntity<TipoEntrenamientoDTO> createTipoEntrenamiento(@RequestBody TipoEntrenamientoDTO tipoEntrenamientoDTO) {
        TipoEntrenamientoDTO nuevoTipo = tipoEntrenamientoService.createTipoEntrenamiento(tipoEntrenamientoDTO);
        return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
    }

    // 4. ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<TipoEntrenamientoDTO> updateTipoEntrenamiento(
            @PathVariable("id") Integer idTipo,
            @RequestBody TipoEntrenamientoDTO tipoEntrenamientoDTO) {

        TipoEntrenamientoDTO actualizado = tipoEntrenamientoService.updateTipoEntrenamiento(idTipo, tipoEntrenamientoDTO);

        if (actualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    // 5. ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoEntrenamiento(@PathVariable("id") Integer idTipo) {

        TipoEntrenamientoDTO existing = tipoEntrenamientoService.getTipoEntrenamientoById(idTipo);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tipoEntrenamientoService.deleteTipoEntrenamiento(idTipo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
