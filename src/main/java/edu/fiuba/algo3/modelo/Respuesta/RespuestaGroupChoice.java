package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RespuestaGroupChoice extends Respuesta{
    private HashMap<String, ArrayList<Integer>> respuesta;
    private ArrayList<String> grupos;

    public RespuestaGroupChoice(HashMap<String, ArrayList<Integer>> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajeNormal();
    }

    public void setGrupos(ArrayList<String> grupos) {
        this.grupos = grupos;
    }

    @Override
    public Integer comparar(Respuesta respuesta) {
        RespuestaGroupChoice respuestaCorrecta = (RespuestaGroupChoice) respuesta;
        if (respuestaCorrecta.evaluar(this.respuesta)) {
            return this.puntaje.getValorRespuestaCorrecta();
        }
        return this.puntaje.getValorRespuestaIncorrecta();
    }

    public boolean evaluar(HashMap<String, ArrayList<Integer>> respuesta) {
        ArrayList<Integer> unGrupoRespuestaCorrecta = this.respuesta.get(grupos.get(0));
        ArrayList<Integer> grupoRespuestaElegida = respuesta.get(grupos.get(0));
        System.out.println(grupos.get(0));
        System.out.println(unGrupoRespuestaCorrecta);
        System.out.println(grupoRespuestaElegida);
        return new HashSet<>(unGrupoRespuestaCorrecta).equals(new HashSet<>(grupoRespuestaElegida));
    }

}