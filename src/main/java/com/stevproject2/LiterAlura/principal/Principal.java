package com.stevproject2.LiterAlura.principal;

import java.util.Scanner;

import com.stevproject2.LiterAlura.model.DatosLibro1;
import com.stevproject2.LiterAlura.model.LibroCont;
import com.stevproject2.LiterAlura.service.ConsumoAPI;
import com.stevproject2.LiterAlura.service.ConvierteDatos;

public class Principal {
    
        private Scanner teclado = new Scanner(System.in);
        private ConsumoAPI consumoApi = new ConsumoAPI();
        private final String URL = "https://gutendex.com/books/?search=";
        private ConvierteDatos conversor = new ConvierteDatos();
    
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



        private DatosLibro1 getBuscarLibroPorTítulo() {
            System.out.println("Ingrese el título del libro a buscar: ");
            var titulo = teclado.nextLine();
            var json = consumoApi.obtenerDatos(URL+ titulo.replace(" ", "%20"));
            System.out.println(consumoApi);
            DatosLibro1 datos = conversor.obtenerDatos(json, DatosLibro1.class);

            datos.stream().map(l --> new LibroCont());
            
            System.out.println(datos);
            return datos;
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

