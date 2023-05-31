package com.infotp1.futApp5;

import com.infotp1.futApp5.domain.Jugador;
import com.infotp1.futApp5.service.entrada.file.impl.inputFileServiceImpl;
import com.infotp1.futApp5.service.menu.MenuOpciones;
import com.infotp1.futApp5.service.menu.impl.MenuOpcionesImpl;
import com.infotp1.futApp5.service.salida.OutputFileService;
import com.infotp1.futApp5.service.salida.impl.OutputFileServiceImpl;

import java.io.IOException;

public class App {



    private static final inputFileServiceImpl inputFileService = new inputFileServiceImpl();

    private static final OutputFileService outputFileService = new OutputFileServiceImpl();


    public static void main(String[] args) throws IOException {


        MenuOpciones menuOpciones = new MenuOpcionesImpl();
        menuOpciones.menu();

        String rutaArchivo = "com/infotp1/futApp5/resources/listJugEnt.txt";

        Jugador jugadores = inputFileService.importarJugadores(rutaArchivo);
        System.out.println("El archivo se creo correctamente");

        String rutaArchivoSalida = "com/infotp1/futApp5/resources";
        System.out.println("El archivo se creo correctamente");

        outputFileService.exportarJugadoresAArchivo(rutaArchivoSalida);
    }
}