package Repositorios.Implementaciones;

import Excepciones.ExcepcionDuplicadoId;
import Modelo.Implementaciones.Media;
import Repositorios.Interfaces.Repositorio;

import java.util.HashSet;
import java.util.Set;

public class RepositorioMedia implements Repositorio <Media> {

    private Set<Media> coleccion= new HashSet<>();

    @Override
    public void agregar(Media item) throws ExcepcionDuplicadoId {
        for(Media m: coleccion){
            if(m.getId().equals(item.getId())){
                throw new ExcepcionDuplicadoId("id duplicado.");
            }
        }
        coleccion.add(item);

    }

    @Override
    public void eliminar(String id) throws Exception {
        Media media = buscar(id);
        if (media == null) {
            throw new Exception("El item no existe .");
        }
        coleccion.remove(media);
    }

    @Override
    public Media buscar(String id) throws Exception {
        for (Media media : coleccion) {
            if (media.getId().equals(id)) {
                return media;
            }
        }
        return null;
    }

    @Override
    public java.util.List<Media> obtenerTodos() {
        return new java.util.ArrayList<>(coleccion);
    }




}
