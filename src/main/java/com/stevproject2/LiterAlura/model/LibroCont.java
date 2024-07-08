package com.stevproject2.LiterAlura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import com.stevproject2.LiterAlura.model.SubjectCategorizer;

@Entity
@Table(name = "libros")
public class LibroCont {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UUID;
    @Column(unique = true)
    private String title;
    private List<DatosPerson> autor = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Categoria categoria;;
    private List<String> idioma;
    private int descargas;

    @ManyToMany
    @JoinTable(
        name = "libros_autores",
        joinColumns = @JoinColumn(name = "libroscont_UUID"),
        inverseJoinColumns = @JoinColumn(name = "person_UUID")
    )
    List<Person> autores;


    public LibroCont(DatosLibroCont datosLibroCont) {
        this.title = datosLibroCont.title();
        this.autor = datosLibroCont.autor();
        this.categoria = SubjectCategorizer.categorizeSubjects(datosLibroCont.categoria());
        this.idioma = datosLibroCont.idioma();
        this.descargas = datosLibroCont.descargas();
    }

    public UUID getId() {
        return UUID;
    }

    public void setId(UUID id) {
        this.UUID = id;
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

    public Categoria getCategoria() {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
        result = prime * result + descargas;
        result = prime * result + ((autores == null) ? 0 : autores.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LibroCont other = (LibroCont) obj;
        if (UUID == null) {
            if (other.UUID != null)
                return false;
        } else if (!UUID.equals(other.UUID))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (categoria != other.categoria)
            return false;
        if (idioma == null) {
            if (other.idioma != null)
                return false;
        } else if (!idioma.equals(other.idioma))
            return false;
        if (descargas != other.descargas)
            return false;
        if (autores == null) {
            if (other.autores != null)
                return false;
        } else if (!autores.equals(other.autores))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LibroCont  [title= " + title + ", autor= " + autor +
                ", categoria = " + categoria + ", idioma= " + idioma + ", descargas" + descargas;
    }
}
