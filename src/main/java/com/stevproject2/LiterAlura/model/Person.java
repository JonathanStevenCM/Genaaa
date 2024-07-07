package com.stevproject2.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Person {
private String autor;
private Integer fechaDeNacimiento;
private String fechaDeSuMuerte;




public Person(DatosPerson datosPerson) {
    this.autor = datosPerson.autor();
    this.fechaDeNacimiento = datosPerson.fechaDeNacimiento();
    this.fechaDeSuMuerte = datosPerson.fechaDeSuMuerte();
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
public String toString() {
    return "Person [autor=" + autor + ", fechaDeNacimiento=" + fechaDeNacimiento +
    ", fechaDeSuMuerte=" + fechaDeSuMuerte + "]";
}


}
