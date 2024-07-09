package com.stevproject2.LiterAlura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UUID;
    private String autor;
    private Integer fechaDeNacimiento;
    private Integer fechaDeSuMuerte;

    @ManyToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LibroCont> libros;


    public Person(){}
    
    public Person(String autor, Integer fechaDeNacimiento, Integer fechaDeSuMuerte){
        this.autor = autor;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeSuMuerte = fechaDeSuMuerte;
    }


    public static Person conversorPerson(List<Person> persona){
        return (Person) persona.stream().map(l -> new Person(l.getAutor(), l.getFechaDeNacimiento(),l.getFechaDeSuMuerte()));
    }



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

    public Long getUUID() {
        return UUID;
    }

    public void setUUID(Long uUID) {
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

    public Integer getFechaDeSuMuerte() {
        return fechaDeSuMuerte;
    }

    public void setFechaDeSuMuerte(Integer fechaDeSuMuerte) {
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
