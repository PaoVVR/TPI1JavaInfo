package com.infotp1.futApp5.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String fechaCreacion;
    private Entrenador entrenador;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String fechaCreacion, Entrenador entrenador) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return (List<Jugador>) jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = (List<Jugador>) jugadores;
    }
}
