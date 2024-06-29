package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;
import java.util.stream.Collectors;

public class ObtenedorPreguntaSiguienteSegunTema implements ObtenedorPreguntaSiguiente {
    private List<Pregunta> preguntas;
    private Pregunta preguntaActual;

    public ObtenedorPreguntaSiguienteSegunTema(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    private Pregunta obtenerUnaPreguntaPorPosicion() {
        Integer idProximaPreguntaProbable = (int) (Math.random() * this.preguntas.size());
        return this.preguntas.get(idProximaPreguntaProbable);
    }

    private boolean verificarPreguntasRestantes() {
        String temaPregunta = this.preguntas.get(0).obtenerTema();
        List<Pregunta> preguntasConDistintoTema = this.preguntas.stream().filter(pregunta -> !(pregunta.obtenerTema().equals(temaPregunta))).collect(Collectors.toList());
        return preguntasConDistintoTema.isEmpty();
    }

    private void verificarDisponibilidadPreguntas() {
        if (this.preguntas.isEmpty()) {
            throw new SinPreguntasDisponiblesException();
        }
    }

    @Override
    public Pregunta obtenerPreguntaSiguiente() {
        this.verificarDisponibilidadPreguntas();
        Pregunta proximaPregunta;
        if ((preguntaActual != null) && (!verificarPreguntasRestantes())) {
            proximaPregunta = this.obtenerUnaPreguntaPorPosicion();
            while (proximaPregunta.obtenerTema().equals(this.preguntaActual.obtenerTema())) {
                proximaPregunta = obtenerUnaPreguntaPorPosicion();
            }
        }
        else {
            proximaPregunta = this.obtenerUnaPreguntaPorPosicion();
        }

        this.preguntaActual = proximaPregunta;
        this.preguntas.remove(proximaPregunta);
        return proximaPregunta;
    }
}