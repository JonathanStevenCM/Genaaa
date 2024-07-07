package com.stevproject2.LiterAlura.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.stevproject2.LiterAlura.model.SubjectCategorizer;

// @Entity
// @Table(name = "libros")
public class LibroCont {
    // @Id
    private Integer id;
    // @Column(unique = true)
    private String title;
    private List<DatosPerson> autor = new ArrayList<>();
    private List<Categoria> categoria;
    private List<String> idioma;
    private int descargas;


    public LibroCont(DatosLibroCont datosLibroCont){
        this.id = datosLibroCont.id();
        this.title = datosLibroCont.title();
        this.autor = datosLibroCont.autor();
        this.categoria = SubjectCategorizer.categorizeSubjects( datosLibroCont.categoria());
        this.idioma = datosLibroCont.idioma();
        this.descargas = datosLibroCont.descargas();
    }

    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public List<DatosPerson> getAutor() {
        return autor;
    }



    public void setAutor(List<DatosPerson> autor) {
        this.autor = autor;
    }



    public List<Categoria> getCategoria() {
        return categoria;
    }



    public void setCategoria(List<String> categoria) {
        this.categoria = SubjectCategorizer.categorizeSubjects(categoria);
    }



    public List<String> getIdioma() {
        return idioma;
    }



    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }



    public int getDescargas() {
        return descargas;
    }



    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }



    @Override
    public String toString() {
        return "LibroCont [id= " + id + ", title= " + title + ", autor= " + autor +
        ", categoria = " + categoria + ", idioma= " + idioma + ", descargas" + descargas;
    }
}
