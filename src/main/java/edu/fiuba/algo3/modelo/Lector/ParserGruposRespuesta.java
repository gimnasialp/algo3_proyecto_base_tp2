package edu.fiuba.algo3.modelo.Lector;

import java.util.ArrayList;
import java.util.HashMap;

public class ParserGruposRespuesta {
    public HashMap<String, ArrayList<Integer>> parsearGruposRespuesta(String respuesta) {
        String[] grupos = respuesta.split(";");
        HashMap<String, ArrayList<Integer>> claveValor = new HashMap<>();
        for (String grupo : grupos) {
            String[] claveValorGrupo = grupo.split(":");
            String clave = claveValorGrupo[0];
            String[] valores = claveValorGrupo[1].split(",");
            ArrayList<Integer> listaValor = new ArrayList<>();
            for (String valor : valores) {
                listaValor.add(Integer.parseInt(valor.trim()));
            }
            claveValor.put(clave, listaValor);
        }

        return claveValor;
    }
}
