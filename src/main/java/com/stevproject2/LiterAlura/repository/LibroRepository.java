package com.stevproject2.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stevproject2.LiterAlura.model.LibroCont;
import com.stevproject2.LiterAlura.model.Person;

public interface LibroRepository extends JpaRepository<LibroCont, Long> {

    // Buscar libro por título
    @Query("SELECT l FROM LibroCont l WHERE l.title = :title")
    List<LibroCont> findByTitle(@Param("title") String title);

    // Listar todos los libros registrados
    @Query("SELECT l FROM LibroCont l")
    List<LibroCont> findAllLibros();

    // Listar todos los autores registrados
    @Query("SELECT DISTINCT p FROM Person p")
    List<Person> findAllAutores();

    // Listar autores vivos en un determinado año
    @Query("SELECT DISTINCT p FROM Person p WHERE p.fechaDeNacimiento <= :year AND (p.fechaDeSuMuerte IS NULL OR p.fechaDeSuMuerte >= :year)")
    List<Person> findAutoresVivosEnAnio(@Param("year") Integer year);

    // Listar libros por idioma
    @Query("SELECT l FROM LibroCont l JOIN l.idioma i WHERE i = :idioma")
    List<LibroCont> findByIdioma(@Param("idioma") String idioma);
}
