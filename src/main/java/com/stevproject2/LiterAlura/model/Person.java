package com.stevproject2.LiterAlura.model;




import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UUID;
    

    @Column(unique = true)
    private String autor;
    private Integer fechaDeNacimiento;
    private String fechaDeSuMuerte;

    @ManyToMany(mappedBy = "autores")
    private List<LibroCont> libros;



    public List<LibroCont> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroCont> libros) {
        this.libros = libros;
    }

    public Person(DatosPerson datosPerson) {
        this.autor = datosPerson.autor();
        this.fechaDeNacimiento = datosPerson.fechaDeNacimiento();
        this.fechaDeSuMuerte = datosPerson.fechaDeSuMuerte();
    }

    public UUID getUUID() {
        return UUID;
    }

    public void setUUID(UUID uUID) {
        UUID = uUID;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFechaDeSuMuerte() {
        return fechaDeSuMuerte;
    }

    public void setFechaDeSuMuerte(String fechaDeSuMuerte) {
        this.fechaDeSuMuerte = fechaDeSuMuerte;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((fechaDeNacimiento == null) ? 0 : fechaDeNacimiento.hashCode());
        result = prime * result + ((fechaDeSuMuerte == null) ? 0 : fechaDeSuMuerte.hashCode());
        result = prime * result + ((libros == null) ? 0 : libros.hashCode());
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
        Person other = (Person) obj;
        if (UUID == null) {
            if (other.UUID != null)
                return false;
        } else if (!UUID.equals(other.UUID))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (fechaDeNacimiento == null) {
            if (other.fechaDeNacimiento != null)
                return false;
        } else if (!fechaDeNacimiento.equals(other.fechaDeNacimiento))
            return false;
        if (fechaDeSuMuerte == null) {
            if (other.fechaDeSuMuerte != null)
                return false;
        } else if (!fechaDeSuMuerte.equals(other.fechaDeSuMuerte))
            return false;
        if (libros == null) {
            if (other.libros != null)
                return false;
        } else if (!libros.equals(other.libros))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [autor=" + autor + ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", fechaDeSuMuerte=" + fechaDeSuMuerte + "]";
    }

}
