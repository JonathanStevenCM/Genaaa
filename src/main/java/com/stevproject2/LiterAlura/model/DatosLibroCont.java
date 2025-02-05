package com.stevproject2.LiterAlura.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibroCont(
@JsonAlias("title")String title,
@JsonAlias("authors")List<DatosPerson> autor,
@JsonAlias("subjects") List<String> categoria,
@JsonAlias("languages")List<String> idioma,
@JsonAlias("download_count") Integer descargas) {

}
