package com.infotp1.futApp5.service.equipo;

import java.util.Scanner;
import java.util.List;

import com.infotp1.futApp5.domain.Equipo;
import com.infotp1.futApp5.service.menu.impl.MenuOpcionesImpl;

public interface EquipoService {
    List<Equipo> listaDeEquipo(MenuOpcionesImpl menuOpciones);
    void crearEquipo(Scanner scanner);
    void buscarJugadorPorNombre(Scanner scanner);
    void buscarEquipoPorNombre(Scanner scanner);
    void mostrarJugadoresEquipo(Scanner scanner);
    void eliminarEquipo(Scanner scanner);
    void importarJugadoresDesdeArchivo(Scanner scanner);
    void exportarJugadoresAArchivo(Scanner scanner);
}
