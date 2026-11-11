package com.Flor.biblioteca.repository;

import com.Flor.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository <Biblioteca,Integer> {
}
