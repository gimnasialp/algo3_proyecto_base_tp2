package edu.fiuba.algo3.modelo.Lector;

import java.util.ArrayList;

public class ParserListaRespuesta {
    public ArrayList<Integer> parsearListaRespuesta(String respuesta) {
        String[] lista = respuesta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }

        return listaRespuesta;
    }
}
