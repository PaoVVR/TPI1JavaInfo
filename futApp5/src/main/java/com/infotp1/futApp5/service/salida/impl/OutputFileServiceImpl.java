package com.infotp1.futApp5.service.salida.impl;

import com.infotp1.futApp5.domain.Jugador;
import com.infotp1.futApp5.service.salida.OutputFileService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFileServiceImpl implements OutputFileService {
    public void exportarJugadoresAArchivo(String nombreArchivo, List<Jugador> jugadores) {
        try (FileWriter fileWriter = new FileWriter("listJugSalida.txt")) {
            // Escribir los jugadores en el archivo
            for (Jugador jugador : jugadores) {
                String linea = jugador.getNombre() + "," + jugador.getApellido() + "," + jugador.getAltura() + "," +
                        jugador.getPosicion() + "," + jugador.getGoles() + "," + jugador.getPartidos() + "," +
                        jugador.esCapitan() + "," + jugador.getNumeroCamiseta() + "," + jugador.getEquipo().getNombre();
                fileWriter.write(linea);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al exportar jugadores al archivo: " + e.getMessage());
        }
    }


    @Override
    public void exportarJugadoresAArchivo(String rutaArchivoSalida) {

    }
}
