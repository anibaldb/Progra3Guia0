package UI;

import Modelo.Implementaciones.Expansion;
import Modelo.Implementaciones.Juego;
import Modelo.Implementaciones.Media;
import Repositorios.Implementaciones.RepositorioMedia;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private RepositorioMedia repo = new RepositorioMedia();

    public void iniciar() {

        int opcion = 0;
        do {
            System.out.println("1. Agregar Media");
            System.out.println("2. Mostrar");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarMedia();
                    break;
                case 2:
                    mostrarJuegos();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);


    }



    private void mostrarJuegos() {
        System.out.println("Juegos en la biblioteca:");

        List<Media> lista = repo.obtenerTodos();

        lista.sort(Comparator.comparing(Media::getTitulo));

        for (Modelo.Implementaciones.Media media : lista) {
            if(media instanceof Juego){
                System.out.println("Tipo: Juego, Versión: " + ((Juego) media).getVersion());
            } else if (media instanceof Expansion) {
                System.out.println("Tipo: Expansión, Fecha de Lanzamiento: " + ((Expansion) media).getFechaLanzamiento());
            }
                System.out.println("ID: " + media.getId() + ", Título: " + media.getTitulo() + ", Creador: " + media.getCreador() + ", Género: " + media.getGenero());


        }

    }

    private void agregarMedia() {
        try {
            System.out.println("Ingrese el tipo de media (1 para Juego, 2 para Expansión):");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("Ingrese el ID de la media:");
            String id = scanner.nextLine();

            System.out.println("Ingrese el título de la media:");
            String titulo = scanner.nextLine();

            System.out.println("Ingrese el creador de la media:");
            String creador = scanner.nextLine();

            System.out.println("Ingrese el género de la media:");
            String genero = scanner.nextLine();

            if (tipo == 1) {
                System.out.println("Ingrese la versión del juego:");
                int version = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                Juego j = new Juego(id, titulo, creador, genero, version);
                repo.agregar(j);

            } else if (tipo == 2) {
                System.out.println("Ingrese la fecha de lanzamiento de la expansión (YYYY-MM-DD):");
                String fechaLanzamiento = scanner.nextLine();

                Expansion e = new Expansion(id, titulo, creador, genero, java.time.LocalDate.parse(fechaLanzamiento));
                repo.agregar(e);

            }

        } catch (Exception e) {
            System.out.println("Error al agregar la media: " + e.getMessage());
        }
    }

}











