package edu.fiuba.algo3.modelo.Preguntas.VoF;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class VerdaderoFalso implements Pregunta {

    private final ArrayList<Respuesta> opciones;
    private final String enunciado;

    public VerdaderoFalso(String unEnunciado, ArrayList<Respuesta> opciones) {
        this.enunciado = unEnunciado;
        this.opciones = opciones;
    }

    public abstract int evaluar(Respuesta respuesta);

    //Este metodo responde a la pregunta de esta clase(atributo 'enunciado')
    //con las respuestas de todos los Jugadores(por eso es una lista de listas)
    //uso get(0) ya que, al ser V o F, cada lista solo tendra un objeto respuesta
    @Override
    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();

        for (ArrayList<Respuesta> respuestaList : respuestas) {
            for (Respuesta respuesta : respuestaList) {
                puntos.add(evaluar(respuesta));
            }
        }
        //
        return puntos;
    }
}
