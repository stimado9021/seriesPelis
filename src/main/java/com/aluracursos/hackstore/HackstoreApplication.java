package com.aluracursos.hackstore;

import com.aluracursos.hackstore.Principal.Principal;
import com.aluracursos.hackstore.Service.ConsumoApi;
import com.aluracursos.hackstore.Service.ConvierteDatos;
import com.aluracursos.hackstore.Service.IConvierteDatos;
import com.aluracursos.hackstore.model.DatosEpisode;
import com.aluracursos.hackstore.model.DatosSerie;
import com.aluracursos.hackstore.model.DatosTemporada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HackstoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(HackstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
		//ListaNombres listaNombre = new ListaNombres();
		//listaNombre.muestraNombres();



	}


}
