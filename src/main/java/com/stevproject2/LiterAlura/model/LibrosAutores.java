package com.stevproject2.LiterAlura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "librosAutores")
public class LibrosAutores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibrosAutores;
    private int idLibro;
    private Long idPerson;


}
