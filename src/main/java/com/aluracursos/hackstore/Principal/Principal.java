package com.aluracursos.hackstore.Principal;

import com.aluracursos.hackstore.Service.ConsumoApi;
import com.aluracursos.hackstore.Service.ConvierteDatos;
import com.aluracursos.hackstore.model.DatosEpisode;
import com.aluracursos.hackstore.model.DatosSerie;
import com.aluracursos.hackstore.model.DatosTemporada;
import com.aluracursos.hackstore.model.Episodio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoApi consumoApi=new ConsumoApi();
    private final ConvierteDatos conversor= new ConvierteDatos();
    private  final String URL_BASE="https://www.omdbapi.com/?t=";
    private  final String API_KEY = "&apikey=f59b2c4";
    private int month;

    public void muestraElMenu(){
          System.out.println("ingrese pelicula que desea buscar : ");
          var nombreSerie = teclado.nextLine();

          var json =	consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+") + API_KEY);
         var datos = conversor.obtenerDatos(json, DatosSerie.class);
         // System.out.println(datos);
        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <=  datos.totalTemporadas() ; i++) {
                     json =	consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ","+")+"&Season=" + i + API_KEY);
                   //  System.out.println(URL_BASE + nombreSerie.replace(" ","+") + i + API_KEY);
                      var datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
                    temporadas.add(datosTemporada);
                    }
               // temporadas.forEach(System.out::println);

//        for (int i = 0; i < datos.totalTemporadas() ; i++) {
//            List<DatosEpisode> episodeTemp =    temporadas.get(i).episodeList();
//            for (int j = 0; j <episodeTemp.size() ; j++) {
//                System.out.println(episodeTemp.get(j).Titulo());
//            }
//        }

        //temporadas.forEach(t->t.episodeList().forEach(e->System.out.println(e.Titulo())));

        List<DatosEpisode> datosEpisodes = (List<DatosEpisode>) temporadas.stream()
                .flatMap(t->t.episodeList().stream())
                        .collect(Collectors.toList());

        datosEpisodes.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DatosEpisode::evaluacion).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t->t.episodeList().stream()
                        .map(d->new Episodio(t.numero(),d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);
System.out.println("Indique desde que año desea ver los capitulos");
        var fecha = teclado.nextLine();
        teclado.nextLine();



        LocalDate fechaBusqueda = LocalDate.of();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e->e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e-> System.out.println(
                        "Temporada : " +  e.getTemporada() +
                        " Episodio : " + e.getTitulo() +
                        " Fecha de  Lanzamiento : " + e.getFechaDeLanzamiento().format(dtf)
                ));




    }
}
