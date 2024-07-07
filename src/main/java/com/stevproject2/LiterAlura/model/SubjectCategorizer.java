package com.stevproject2.LiterAlura.model;

import java.util.ArrayList;
import java.util.List;

public class SubjectCategorizer {
    public static Categoria categorize(String subject) {
        if (subject.toLowerCase().contains("adventure")) {
            return Categoria.AVENTURA;
        } else if (subject.toLowerCase().contains("love")) {
            return Categoria.AMOR;
        } else if (subject.toLowerCase().contains("sadness")) {
            return Categoria.TRISTEZA;
        } else if (subject.toLowerCase().contains("action")) {
            return Categoria.ACCION;
        } else if (subject.toLowerCase().contains("drama")) {
            return Categoria.DRAMA;
        } else if (subject.toLowerCase().contains("romance")) {
            return Categoria.ROMANCE;
        } else if (subject.toLowerCase().contains("comedy")) {
            return Categoria.COMEDIA;
        } else if (subject.toLowerCase().contains("fiction")) {
            return Categoria.FICCION;
        } else {
            return Categoria.DESCONOCIDO;
        }
    }

    public static Categoria categorizeSubjects(List<String> subjects) {
        for (String subject : subjects) {
            Categoria category = categorize(subject);
            if (category != Categoria.DESCONOCIDO) {
                return category;
            }
        }
        return Categoria.DESCONOCIDO;
    }
}