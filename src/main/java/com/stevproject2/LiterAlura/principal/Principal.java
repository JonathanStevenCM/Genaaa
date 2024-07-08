package com.stevproject2.LiterAlura.principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.stevproject2.LiterAlura.model.DatosLibro1;
import com.stevproject2.LiterAlura.model.DatosLibroCont;
import com.stevproject2.LiterAlura.model.Libro1;
import com.stevproject2.LiterAlura.model.LibroCont;
import com.stevproject2.LiterAlura.model.Person;
import com.stevproject2.LiterAlura.repository.LibroRepository;
import com.stevproject2.LiterAlura.service.ConsumoAPI;
import com.stevproject2.LiterAlura.service.ConvierteDatos;

public class Principal {
    
        private Scanner teclado = new Scanner(System.in);
        private ConsumoAPI consumoApi = new ConsumoAPI();
        private final String URL = "https://gutendex.com/books/?search=";
        private ConvierteDatos conversor = new ConvierteDatos();
        
        private LibroRepository repositorio;

        public Principal(LibroRepository repository) {
            this.repositorio = repository;
        }
        public Principal(){}
    
        public void muestraElMenu() {
            var opcion = -1;
            while (opcion != 0) {
                var menu = """
                        Elija la opción a través de su número:
                        1- buscar libro por título
                        2- listar libros registrados
                        3- listar autores registrados
                        4- listar autores vivos en un determinado año
                        5- listar libros por idioma
                        6- libros web
    
                        0 - salir
                        """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();
    
                switch (opcion) {
                    case 1:
                        buscarLibroPorTítulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosEnUnDeterminadoAño();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            }
    
        }

        

        
        




        private DatosLibro1 getDatosLibro1() {
            System.out.println("Ingrese el título del libro a buscar: ");
            var titulo = teclado.nextLine();
            var json = consumoApi.obtenerDatos(URL+ titulo.replace(" ", "%20"));
            DatosLibro1 datos = conversor.obtenerDatos(json, DatosLibro1.class);
            
            return datos;
        }

        private void buscarLibroPorTítulo() {
            DatosLibro1 datos = getDatosLibro1();
            List<DatosLibro1> datosLibros = new ArrayList<>();
            datosLibros.add(datos);
            System.out.println(datosLibros);
            List<Libro1> libro = new ArrayList<>();
            libro = datosLibros.stream().map(d -> new Libro1(d)).collect(Collectors.toList());
            System.out.println(libro);
            List<LibroCont> libroCont = new ArrayList<>();
            libroCont  =   libro.stream().flatMap(libro1 -> libro1.getResultado().stream()).map(l -> new LibroCont()).collect(Collectors.toList());
            System.out.println(libroCont);
            Optional<LibroCont> libroCont2 = libroCont.stream().map(l -> new LibroCont(l.getId(), l.getTitle(), l.getAutor(), l.getCategoria(), l.getIdioma(), l.getDescargas())).findFirst();
            System.out.println(libroCont2);
            LibroCont libroCont3 = libroCont2.orElse(new LibroCont());
            System.out.println(libroCont3);
            repositorio.save(libroCont3);
        }

        private void listarLibrosRegistrados() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listarLibrosRegistrados'");
        }

        private void listarAutoresRegistrados() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listarAutoresRegistrados'");
        }

        private void listarAutoresVivosEnUnDeterminadoAño() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listarAutoresVivosEnUnDeterminadoAño'");
        }

        private void listarLibrosPorIdioma() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listarLibrosPorIdioma'");
        }

}

