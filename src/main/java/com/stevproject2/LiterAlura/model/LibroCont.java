package com.stevproject2.LiterAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroCont {
    @JsonAlias("id")Integer id;
    @JsonAlias("title")String title;
    @JsonAlias("authors")List<Person> autor;
    @JsonAlias("subjects") List<String> categoria;
    @JsonAlias("languages")List<String> idioma;
    @JsonAlias("download_count") int descargas;



    @Override
    public String toString() {
        return "LibroCont [id=" + id + ", title=" + title + ", autor";
    }
}
