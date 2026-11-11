package com.Flor.biblioteca.service;

import com.Flor.biblioteca.model.Biblioteca;
import com.Flor.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BibliotecaService {
    private BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository){
        this.bibliotecaRepository = bibliotecaRepository;
    }
    //TRAER TODOS
    public List<Biblioteca> traerTodos(){
        return bibliotecaRepository.findAll();
    }

    //GUARDAR
    public Biblioteca guardar (Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }
    //EDITAR
    // EDITAR
    public Optional editar(int id, Biblioteca bibliotecaActualizada) {
        return bibliotecaRepository.findById(id)
                .map(libroExiste -> {
                    libroExiste.setTitulo(bibliotecaActualizada.getTitulo());
                    libroExiste.setAutor(bibliotecaActualizada.getAutor());
                    libroExiste.setAnio(bibliotecaActualizada.getAnio());
                    libroExiste.setDisponible(bibliotecaActualizada.isDisponible());

                    return bibliotecaRepository.save(libroExiste);
                });
}
