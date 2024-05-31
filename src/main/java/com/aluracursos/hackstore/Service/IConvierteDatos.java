package com.aluracursos.hackstore.Service;

public interface IConvierteDatos {
    <T>  T obtenerDatos(String json,Class<T> Class );

}
