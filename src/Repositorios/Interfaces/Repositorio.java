package Repositorios.Interfaces;

import java.util.List;

public interface Repositorio<T>{

    public void agregar(T item) throws Exception;
    public void eliminar(String id) throws Exception;
    public T buscar(String id) throws Exception;
    List<T> obtenerTodos();


}
