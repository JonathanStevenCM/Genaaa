package com.stevproject2.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record DatosPerson(@JsonAlias("name")String autor,
@JsonAlias("birth_year")Integer fechaDeNacimiento,
@JsonAlias("death_year")String fechaDeSuMuerte) {
}


