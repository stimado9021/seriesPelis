package com.aluracursos.hackstore.Service;

import com.aluracursos.hackstore.model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
    private ObjectMapper ObjectMapper = new ObjectMapper();

    public DatosSerie obtenerDatos(String Json) {
        return null;
    }

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return ObjectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
