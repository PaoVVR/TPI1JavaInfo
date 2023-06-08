package com.infotp1.futApp5.service.entrada.file.impl;

import com.infotp1.futApp5.domain.Jugador;
import com.infotp1.futApp5.service.entrada.file.inputFileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class inputFileServiceImpl implements inputFileService {
    @Override
    public Jugador importarJugadores(String nombreArchivo) {
        List<Jugador> jugadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Suponiendo que los datos están separados por comas

                //tengo que crear el objeto jugador utilizando los datos de cada línea del archivo y agregarlo a la lista de jugadores
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (Jugador) jugadores;
    }
}
