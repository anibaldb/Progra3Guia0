package Modelo.Implementaciones;

import Modelo.Interfaces.Identificable;

public abstract class Media implements Identificable, Comparable<Media> {
    private String id;
    private String titulo;
    private String creador;
    private String genero;


    public Media(String id, String titulo, String creador, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int compareTo(Media other) {
        return this.id.compareTo(other.id);

    }
}

