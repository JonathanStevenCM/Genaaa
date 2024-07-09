package com.stevproject2.LiterAlura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stevproject2.LiterAlura.model.LibroCont;
import com.stevproject2.LiterAlura.model.Person;

public interface LibroRepository extends JpaRepository<LibroCont, Long> {
    @Query("SELECT l FROM LibroCont l")
    List<LibroCont> findAllBooks();

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.libros")
    List<Person> findAllAuthors();

    @Query("SELECT p FROM Person p WHERE (p.fechaDeNacimiento <= :year) AND (p.fechaDeSuMuerte >= :year OR p.fechaDeSuMuerte IS NULL)")
    List<Person> findLivingAuthorsByYear(@Param("year") int year);

    @Query("SELECT l FROM LibroCont l JOIN l.idioma i WHERE i IN :idiomas")
    List<LibroCont> findBooksByLanguages(@Param("idiomas") List<String> idiomas);
    
}
