package com.stevproject2.LiterAlura.model;

import java.util.List;

public class Libro1 {
    private List<DatosLibroCont> resultado;


    public Libro1(DatosLibro1 datosLibro1){
        this.resultado = datosLibro1.resultado();
    }



    public List<DatosLibroCont> getResultado() {
        return resultado;
    }

    public void setResultado(List<DatosLibroCont> resultado) {
        this.resultado = resultado;
    }



    @Override
    public String toString() {
        return "Libro1 [resultado=" + resultado + "]";
    }
    
}
