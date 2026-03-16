package Modelo.Implementaciones;

import java.time.LocalDate;

public class Expansion extends Media{
    public LocalDate fechaLanzamiento;

    public Expansion(String id, String titulo, String creador, String genero, LocalDate fechaLanzamiento) {
        super(id, titulo, creador, genero);

        if(fechaLanzamiento == null) {
            throw new IllegalArgumentException("La fecha de lanzamiento no puede ser nula.");
        }

        this.fechaLanzamiento = fechaLanzamiento;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

}
