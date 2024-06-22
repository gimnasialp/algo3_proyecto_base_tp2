package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RespuestaGroupChoice extends Respuesta{
    private HashMap<String, ArrayList<Integer>> respuesta;

    public RespuestaGroupChoice(HashMap<String, ArrayList<Integer>> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajeNormal();
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        RespuestaGroupChoice respuestaJugador = (RespuestaGroupChoice) respuesta;
        return respuestaJugador.evaluar(this.respuestaGrupoUno, this.respuestaGrupoDos);
    }

    private boolean evaluar(ArrayList<Integer> respuestaCorrectaGrupoUno, ArrayList<Integer> respuestaCorrectaGrupoDos) {
        boolean primeraCondicion = new HashSet<>(this.respuestaGrupoUno).equals(new HashSet<>(respuestaCorrectaGrupoUno));
        boolean segundaCondicion = new HashSet<>(this.respuestaGrupoUno).equals(new HashSet<>(respuestaCorrectaGrupoDos));
        if (primeraCondicion || segundaCondicion) {
            return true;
        } else {
            return false;
        }
    }

}
