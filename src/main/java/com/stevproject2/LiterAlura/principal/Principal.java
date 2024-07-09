package com.stevproject2.LiterAlura.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;

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
            try {
                var opcion = -1;
            while (opcion != 0) {
                var menu = """
                        Elija la opción a través de su número:
                        1- buscar libro por título
                        2- listar libros registrados
                        3- listar autores registrados
                        4- listar autores vivos en un determinado año
                        5- listar libros por idioma
    
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
    
                
            }  catch (InputMismatchException e) {
                System.out.println("No ingresaste una opcion, vuelva a intentar");
                System.out.println("------------------------");
                Principal principal = new Principal(repositorio);
		        principal.muestraElMenu();
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
            try {
                DatosLibro1 datos = getDatosLibro1();
                List<DatosLibro1> datosLibros = new ArrayList<>();
                datosLibros.add(datos);
                System.out.println(datosLibros);
                //Transformando a lista de libro
                List<Libro1> libro = new ArrayList<>();
                libro = datosLibros.stream().map(d -> new Libro1(d)).collect(Collectors.toList());
                //Transformando a un Libro
                List<LibroCont> libroCont = new ArrayList<>();
                libroCont  =   libro.stream().flatMap(libro1 -> libro1.getResultado().stream()).map(l -> new LibroCont(l)).collect(Collectors.toList());
                Optional<LibroCont> libroCont2 = libroCont.stream().map(l -> new LibroCont(l.getId(), l.getTitle(), l.getAutor(), l.getCategoria(), l.getIdioma(), l.getDescargas())).findFirst();
                LibroCont libroCont3 = libroCont2.orElse(new LibroCont());
                //Extrayendo el nombre del autor transformando el listado de autor a una persona.
                List<Person> person0=  libroCont3.getAutor();
                Optional<Person> person = person0.stream().map(l -> new Person(l.getAutor(),l.getFechaDeNacimiento(),l.getFechaDeSuMuerte())).findFirst();
                Person person2 = person.orElse(new Person());
                
                repositorio.save(libroCont3);

                System.out.println("--------------------------------");
                System.out.println("Título: " + libroCont3.getTitle());
                System.out.println("Autor: " + person2.getAutor());
                System.out.println("Categoria: " + libroCont3.getCategoria());
                System.out.println("Descargas: " + libroCont3.getDescargas());
                System.out.println("--------------------------------");
            
            } catch(DataIntegrityViolationException e){
                System.out.println("-------------------------------------");
                System.out.println("El libro se repetido, vuelva a intentar");
                System.out.println("-------------------------------------");
                buscarLibroPorTítulo();
            } catch(NullPointerException e){
                System.out.println("-------------------------------------");
                System.out.println("El libro no existe, vuelva a intentarlo");
                System.out.println("-------------------------------------");
                buscarLibroPorTítulo();

            }
            
        }

        private void listarLibrosRegistrados() {
            List<LibroCont> libros = repositorio.findAllBooks();
            for (LibroCont libro : libros) {
                String idiomas = libro.getIdioma();
                for (Person autor : libro.getAutor()) {
                    System.out.println("Nombre del libro: " + libro.getTitle());
                    System.out.println("Autor: " + autor.getAutor());
                    System.out.println("Idioma: " + idiomas);
                    System.out.println("Cantidad de descargas: " + libro.getDescargas());
                    System.out.println("--------------------------------");
                }
            }
            
        }

        private void listarAutoresRegistrados() {
            List<Person> autores = repositorio.findAllAuthors();
            for (Person autor : autores) {
                System.out.println("Autor: " + autor.getAutor());
                System.out.println("Fecha de nacimiento: " + autor.getFechaDeNacimiento());
                System.out.println("Fecha de muerte: " + autor.getFechaDeSuMuerte());
                System.out.println("Libros escritos:");
                for (LibroCont libro : autor.getLibros()) {
                    System.out.println("- " + libro.getTitle());
                }
                System.out.println("--------------------------------");
            }
        }

        private void listarAutoresVivosEnUnDeterminadoAño() {
            System.out.println("Ingrese el año:");
            int year = teclado.nextInt();
            teclado.nextLine();
        
            List<Person> autores = repositorio.findLivingAuthorsByYear(year);
            for (Person autor : autores) {
                System.out.println("Autor: " + autor.getAutor());
                System.out.println("Fecha de nacimiento: " + autor.getFechaDeNacimiento());
                System.out.println("Fecha de muerte: " + autor.getFechaDeSuMuerte());
                System.out.println("Libros escritos:");
                for (LibroCont libro : autor.getLibros()) {
                    System.out.println("- " + libro.getTitle());
                }
                System.out.println("--------------------------------");
            }
        }

        private void listarLibrosPorIdioma() {
            System.out.println("Ingrese los idiomas separados por comas (ej. es,en): ");
            String idiomasInput = teclado.nextLine();
            List<String> idiomas = Arrays.asList(idiomasInput.split(","));
    
            List<Object[]> resultados = repositorio.listarLibrosPorIdioma(idiomas);
            System.out.println("Resultados de la búsqueda:");
            for (Object[] resultado : resultados) {
                System.out.println("Título: " + resultado[0]);
                System.out.println("Autor: " + resultado[1]);
                System.out.println("Idioma: " + resultado[2]);
                System.out.println("Descargas: " + resultado[3]);
                System.out.println("--------------------------------");
            }
        }
    }
        
            



