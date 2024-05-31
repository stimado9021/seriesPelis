package com.aluracursos.hackstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaNombres {

    public  void muestraNombres(){
        List<String> nombres = Arrays.asList("chicho", "ingri", "nidia" ,"judith" , "ana maria", "chino");

        nombres.stream()
                        .sorted()
                        .limit(4)
                        .filter(n -> n.startsWith("c"))
                         .map(n->n.toUpperCase())
                        .forEach(System.out::println);
    }
}
