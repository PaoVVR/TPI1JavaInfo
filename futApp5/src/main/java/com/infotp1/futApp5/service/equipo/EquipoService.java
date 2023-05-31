package com.infotp1.futApp5.service.equipo;

import java.util.Scanner;

public interface EquipoService {
    void crearEquipo(Scanner scanner);
    void buscarJugadorPorNombre(Scanner scanner);
    void buscarEquipoPorNombre(Scanner scanner);
    void mostrarJugadoresEquipo(Scanner scanner);
    void eliminarEquipo(Scanner scanner);
    void importarJugadoresDesdeArchivo(Scanner scanner);
    void exportarJugadoresAArchivo(Scanner scanner);
}
