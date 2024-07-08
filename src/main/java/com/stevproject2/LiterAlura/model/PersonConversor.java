package com.stevproject2.LiterAlura.model;

import java.util.List;
import java.util.stream.Collectors;

public class PersonConversor {
     public static List<Person> convertToPerson(List<DatosPerson> datosPersonList) {
        return datosPersonList.stream()
            .map(datosPerson -> new Person(datosPerson))
            .collect(Collectors.toList());
    }

}
