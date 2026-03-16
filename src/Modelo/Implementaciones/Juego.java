package Modelo.Implementaciones;

public class Juego extends Media{
    private int version;

    public Juego(String id, String titulo, String creador, String genero, int version) {
        super(id, titulo, creador, genero);

        if (version < 0) {
            throw new IllegalArgumentException("La versión no puede ser negativa.");
        }

        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}
