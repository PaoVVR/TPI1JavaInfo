package com.infotp1.futApp5.service.menu.impl;

import com.infotp1.futApp5.service.equipo.EquipoService;
import com.infotp1.futApp5.service.equipo.impl.EquipoServiceImpl;
import com.infotp1.futApp5.service.menu.MenuOpciones;
import com.infotp1.futApp5.service.salida.OutputFileService;
import com.infotp1.futApp5.service.salida.impl.OutputFileServiceImpl;
import java.util.Scanner;

public class MenuOpcionesImpl implements MenuOpciones {

    public static final EquipoService equipoService = new EquipoServiceImpl();
    private static final OutputFileService outputFileService = new OutputFileServiceImpl();

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Fut5App - Menú de opciones");
            System.out.println("1. Crear un equipo");
            System.out.println("2. Buscar jugador por nombre");
            System.out.println("3. Buscar equipo por nombre");
            System.out.println("4. Mostrar jugadores de un equipo");
            System.out.println("5. Eliminar un equipo");
            System.out.println("6. Importar lista de jugadores desde archivo");
            System.out.println("7. Exportar lista de jugadores a archivo");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    equipoService.crearEquipo(scanner);
                    break;
                case 2:
                    equipoService.buscarJugadorPorNombre(scanner);
                    break;
                case 3:
                    equipoService.buscarEquipoPorNombre(scanner);
                    break;
                case 4:
                    equipoService.mostrarJugadoresEquipo(scanner);
                    break;
                case 5:
                    equipoService.eliminarEquipo(scanner);
                    break;
                case 6:
                    equipoService.importarJugadoresDesdeArchivo(scanner);
                    break;
                case 7:
                    equipoService.exportarJugadoresAArchivo(scanner);
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese nuevamente.");
                    break;
            }
        }
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}
