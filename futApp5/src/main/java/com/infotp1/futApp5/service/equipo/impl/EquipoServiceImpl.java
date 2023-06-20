package com.infotp1.futApp5.service.equipo.impl;


import com.infotp1.futApp5.domain.Entrenador;
import com.infotp1.futApp5.domain.Equipo;
import com.infotp1.futApp5.domain.Jugador;
import com.infotp1.futApp5.service.Jugador.JugadorServiceImpl;
import com.infotp1.futApp5.service.equipo.EquipoService;
import com.infotp1.futApp5.service.menu.impl.MenuOpcionesImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EquipoServiceImpl implements EquipoService {

    private JugadorServiceImpl jugadorService = new JugadorServiceImpl();
    private static Scanner scanner;

    MenuOpcionesImpl menuOpciones = new MenuOpcionesImpl();

    @Override
    public List<Equipo> listaDeEquipo(MenuOpcionesImpl menuOpciones){
        return menuOpciones.equipos;
    }

    public final List<Equipo> equipos = listaDeEquipo(menuOpciones);

    public void crearEquipo(Scanner scanner) {
        EquipoServiceImpl.scanner = scanner;
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();
        System.out.print("Ingrese la fecha de creación del equipo: ");
        String fechaCreacion = scanner.next();
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombreEntrenador = scanner.next();
        System.out.print("Ingrese el apellido del entrenador: ");
        String apellidoEntrenador = scanner.next();
        System.out.print("Ingrese la edad del entrenador: ");
        int edadEntrenador = scanner.nextInt();

        Entrenador entrenador = new Entrenador(nombreEntrenador, apellidoEntrenador, edadEntrenador);
        Equipo equipo = new Equipo(nombreEquipo, fechaCreacion, entrenador);
        equipos.add(equipo);

        boolean cargarJugadores = true;
        while (cargarJugadores) {

            Jugador nuevoJugador = jugadorService.crearJugador();
            nuevoJugador.setEquipo(equipo);
            equipo.getJugadores().add(nuevoJugador);

            System.out.print("¿Desea cargar más jugadores para este equipo? (True/False): ");
            cargarJugadores = scanner.nextBoolean();
        }

        System.out.print("¿Desea cargar más equipos? (true/false): ");
        boolean cargarEquipos = scanner.nextBoolean();
        if (!cargarEquipos) {
            System.out.println("Equipos cargados correctamente.");
        }
    }
        /*System.out.print("¿Desea cargar más equipos? (true/false): ");
        boolean cargarEquipos = scanner.nextBoolean();
        scanner.nextLine();

        while (cargarEquipos) {
            crearEquipo(scanner);

            cargarEquipos = scanner.nextBoolean();
            scanner.nextLine();
        }

        System.out.println("Equipos cargados correctamente.");
    }*/





    @Override
    public void buscarEquipoPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo a buscar: ");
        String nombreEquipo = scanner.next();

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                System.out.println("Capitán: " + obtenerNombreCapitan(equipo));
                return;
            }
        }

        System.out.println("No se encontró ningún equipo con ese nombre.");
    }

    private String obtenerNombreCapitan(Equipo equipo) {
        for (Jugador jugador : equipo.getJugadores()) {
            if (!jugador.esCapitan) {
            } else {
                return jugador.getNombre() + " " + jugador.getApellido();
            }
        }

        return "No hay capitán asignado";
    }

    @Override
    public void mostrarJugadoresEquipo(Scanner scanner) {
        EquipoServiceImpl.scanner = scanner;
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                System.out.println("Jugadores del equipo:");

                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println("- " + jugador.getNombre() + " " + jugador.getApellido());
                }

                return;
            }
        }

        System.out.println("No se encontró ningún equipo con ese nombre.");
    }

    @Override
    public void eliminarEquipo(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo a eliminar: ");
        String nombreEquipo = scanner.next();

        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipos.remove(i);
                System.out.println("El equipo ha sido eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún equipo con ese nombre.");
    }

    @Override
    public void importarJugadoresDesdeArchivo(Scanner scanner) {
        // String nombreArchivo = scanner.next();
        String nombreArchivo = "listJugEnt.txt";
        try {
            File archivo = new File("src\\main\\java\\com\\infotp1\\futApp5\\resources\\" + nombreArchivo);
                    Scanner lector = new Scanner(archivo);
            if (lector.hasNextLine()) {        lector.nextLine();
            }
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] campos = linea.split(",");
                if (campos.length == 8) {
                    // Obtener los valores de los campos
                    String nombre = campos[0].trim();
                    String apellido = campos[1].trim();
                    double altura = Double.parseDouble(campos[2].trim());
                    String posicion = campos[3].trim();
                    int goles = Integer.parseInt(campos[4].trim());
                    int partidos = Integer.parseInt(campos[5].trim());
                    boolean esCapitan = Boolean.parseBoolean(campos[6].trim());
                    int numeroCamiseta = Integer.parseInt(campos[7].trim());

                    Jugador jugador = new Jugador(nombre, apellido, altura, posicion, goles,
                            partidos, esCapitan, numeroCamiseta);
                    System.out.println("Importación exitosa" + jugador);
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al importar jugadores desde el archivo: Archivo no encontrado" + e.getMessage());
        }
    }


    @Override
    public void exportarJugadoresAArchivo(Scanner scanner) {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.next();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.next();


        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {

                List<Jugador> jugadores = equipo.getJugadores();

                try (FileWriter writer = new FileWriter("src\\main\\java\\com\\infotp1\\futApp5\\resources\\"+ nombreArchivo)) {

                    for (Jugador jugador : jugadores) {
                        writer.write("Equipo:" + equipo.getNombre() + "; ");
                        writer.write("Apellido y nombre del entrenador:" + equipo.getEntrenador().getApellido() + " " + equipo. getEntrenador().getNombre()+"; ");
                        writer.write("Apellido y nombre del jugador:" +jugador.getApellido() +" "+ jugador.getNombre() + "; ");
                        writer.write("Altura:"+ jugador.getAltura() + "; ");
                        writer.write("Posición:" + jugador.getPosicion() + "; ");
                        writer.write("Cantidad de goles:" + jugador.getGoles() + "; ");
                        writer.write("Cantidad de partidos jugados:" + jugador.getPartidos() + "; ");
                        writer.write("¿El jugador es capitan?:" + jugador.esCapitan() + "; ");
                        writer.write("Número de camiseta:" + jugador.getNumeroCamiseta() + "\n");
                    }

                    System.out.println("Exportación exitosa a " + nombreArchivo);
                } catch (IOException e) {
                    System.out.println("Error al exportar jugadores: " + e.getMessage());
                }

                return;
            }
        }

        System.out.println("No se encontró ningún equipo con ese nombre.");
    }

}
