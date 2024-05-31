package com.aluracursos.hackstore.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio   {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double evaluacion;
    private LocalDate fechaDeLanzamiento;



    public Episodio(Integer numero, DatosEpisode d) {
        this.temporada = numero;
        this.titulo= d.Titulo();
        this.numeroEpisodio= d.NumeroDeEpisodios();
        try {
            this.evaluacion= Double.valueOf(d.evaluacion()) ;
        }catch(NumberFormatException e) {
            this.evaluacion = 0.0;
        }
try {
    this.fechaDeLanzamiento = LocalDate.parse(d.FechaDeLanzamiento()) ;
}catch (DateTimeParseException e){
    this.fechaDeLanzamiento = null;
}


    }

    public static void forEach(Object o) {
    }

//    public static void forEach(Object o) {
//    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer numero,DatosEpisode d) {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    @Override
    public String toString() {
        return
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento;
    }
}
