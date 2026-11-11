package com.Flor.biblioteca.controller;

import com.Flor.biblioteca.model.Biblioteca;
import com.Flor.biblioteca.service.BibliotecaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class bibliotecaController {
    private BibliotecaService bibliotecaService;

    public bibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }
    @GetMapping
    public List<Biblioteca> verTodos(){
        return bibliotecaService.traerTodos();
    }
    //GUARDAR
    @PostMapping
    public ResponseEntity<Biblioteca> guardar(@RequestBody Biblioteca biblioteca){
        Biblioteca nuevoBiblioteca = bibliotecaService.guardar(biblioteca);
        return new ResponseEntity<>(nuevoBiblioteca, HttpStatus.CREATED);
    }
}