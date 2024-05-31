package com.aluracursos.hackstore.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    @JsonIgnoreProperties(ignoreUnknown = true)


public record DatosEpisode(
       @JsonAlias("Title") String Titulo,
       @JsonAlias("Episode") Integer NumeroDeEpisodios,
       @JsonAlias("imdbRating") String evaluacion,
       @JsonAlias("Released") String FechaDeLanzamiento
                    ) {}
