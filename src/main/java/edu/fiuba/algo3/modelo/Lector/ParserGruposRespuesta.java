package edu.fiuba.algo3.modelo.Lector;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGruposRespuesta {
    public HashMap<String, ArrayList<Integer>> parsearGruposRespuesta(String respuesta, ArrayList<String> grupos) {
        String[] gruposRespuesta = respuesta.split(";");
        HashMap<String, ArrayList<Integer>> claveValor = new HashMap<>();
        Integer numeroGrupo = 0;
        for (String grupo : gruposRespuesta) {
            String clave = grupos.get(numeroGrupo);
            String[] claveValorGrupo = grupo.trim().split(":");
            String[] valores = claveValorGrupo[1].trim().split(",");
            ArrayList<Integer> listaValor = new ArrayList<>();
            for (String valor : valores) {
                listaValor.add(Integer.parseInt(valor.trim()));
            }
            claveValor.put(clave, listaValor);
            numeroGrupo++;
        }

        return claveValor;
    }
}
