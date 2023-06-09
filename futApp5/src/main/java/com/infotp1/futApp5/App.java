package com.infotp1.futApp5;

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

        // Agradecimiento especial a Andrea y a Ezequiel que estos ultimos dos días estuvimos
        // trabajando en conjunto para resolver problemas en mi repo y en el de Andre.
        // Observaciones:En la carpeta ArchivosDePrueba la cual se encuentra en resources
        // dejo todas las pruebas realizadas para exportar archivos txt
        // del mismo modo dejo los archivos fallidos que se crearon debajo de gitignore
        // con respecto al input y output se realiza desde consola ingresando la opción 6 o 7
        // queda modificar las interfaces de output e input
        // dejo mi diagrama de clases aqui https://drive.google.com/file/d/1u8AzemlMeiPNOF7vTX27uczz5d90eCz3/view?usp=sharing
    }
}

