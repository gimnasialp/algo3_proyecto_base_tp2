package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.HashMap;

public class FabricaPreguntaGroupChoice extends FabricaPreguntas {

    private Respuesta obtenerRespuesta(String respuestaCorrecta){
        String[] grupos = respuestaCorrecta.split(";");
        HashMap<String, ArrayList<Integer>> claveValor = new HashMap<>();
        for (String grupo : grupos) {
            String[] claveValorGrupo = grupo.trim().split(":");
            String clave = claveValorGrupo[0];
            String[] valores = claveValorGrupo[1].trim().split(",");
            ArrayList<Integer> listaValor = new ArrayList<>();
            for (String valor : valores) {
                listaValor.add(Integer.parseInt(valor.trim()));
            }
            claveValor.put(clave, listaValor);
        }
        ArrayList<Integer> respuestaUno = claveValor.get("A");
        ArrayList<Integer> respuestaDos = claveValor.get("B");
        RespuestaGroupChoice respuesta = new RespuestaGroupChoice(respuestaUno, respuestaDos);
        return respuesta;
    }


    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaGroupChoice preguntaGroupChoice = new PreguntaGroupChoice(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                obtenerRespuesta(parameters[3].toString()), //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaGroupChoice;
    }



}
