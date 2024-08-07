package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaGroupChoice implements Respuesta{

    private final ArrayList<Integer> respuestaGrupoUno;
    private final ArrayList<Integer> respuestaGrupoDos;

    public RespuestaGroupChoice(ArrayList<Integer> respuestaGrupoUno, ArrayList<Integer> respuestaGrupoDos) {
        this.respuestaGrupoUno = respuestaGrupoUno;
        this.respuestaGrupoDos = respuestaGrupoDos;
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
