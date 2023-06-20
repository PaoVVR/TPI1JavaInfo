package com.infotp1.futApp5.service.equipo;

import com.infotp1.futApp5.domain.Equipo;
import com.infotp1.futApp5.service.menu.impl.MenuOpcionesImpl;

import java.util.List;
import java.util.Scanner;

public interface EquipoService {
    List<Equipo> listaDeEquipo(MenuOpcionesImpl menuOpciones);
    void crearEquipo(Scanner scanner);

    void buscarEquipoPorNombre(Scanner scanner);
    void mostrarJugadoresEquipo(Scanner scanner);
    void eliminarEquipo(Scanner scanner);
    void importarJugadoresDesdeArchivo(Scanner scanner);
    void exportarJugadoresAArchivo(Scanner scanner);
}
