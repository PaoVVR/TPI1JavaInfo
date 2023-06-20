package com.infotp1.futApp5.service.Jugador;

import com.infotp1.futApp5.domain.Equipo;
import com.infotp1.futApp5.domain.Jugador;
import com.infotp1.futApp5.service.equipo.impl.EquipoServiceImpl;

import java.util.Scanner;

public class JugadorServiceImpl {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EquipoServiceImpl equipoService =new EquipoServiceImpl();

    public Jugador crearJugador(){
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreJugador = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellidoJugador = scanner.next();
        System.out.print("Ingrese la altura del jugador: ");
        double alturaJugador = scanner.nextDouble();
        System.out.print("Ingrese la posición del jugador (Arquero/Defensor/Mediocampista/Delantero): ");
        String posicionJugador = scanner.next();
        System.out.print("Ingrese la cantidad de goles del jugador: ");
        int golesJugador = scanner.nextInt();
        System.out.print("Ingrese la cantidad de partidos del jugador: ");
        int partidosJugador = scanner.nextInt();
        System.out.print("¿El jugador es capitán? (true/false): ");
        boolean esCapitan = scanner.nextBoolean();
        System.out.print("Ingrese el número de camiseta del jugador: ");
        int numeroCamiseta = scanner.nextInt();

        Jugador jugador = new Jugador(nombreJugador, apellidoJugador, alturaJugador, posicionJugador,
                golesJugador, partidosJugador, esCapitan, numeroCamiseta, null);

        return jugador;
    }
    public void buscarJugadorPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador a buscar: ");
        String nombreJugador = scanner.next();

        for (Equipo equipo : equipoService.equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Posición: " + jugador.getPosicion());
                    System.out.println("Es capitán: " + (jugador.esCapitan() ? "Sí" : "No"));
                    System.out.println("Equipo: " + jugador.getEquipo().getNombre());
                    return;
                }
            }
        }

        System.out.println("No se encontró ningún jugador con ese nombre.");
    }
}
