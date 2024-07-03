package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MezcladorPreguntasSegunTema implements MezcladorPreguntas {
    private ArrayList<Pregunta> preguntas;

    public MezcladorPreguntasSegunTema(ArrayList<Pregunta> preguntas) {
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

    @Override
    public ArrayList<Pregunta> mezclarPreguntas() {
        Pregunta proximaPregunta = this.obtenerUnaPreguntaPorPosicion();
        ArrayList<Pregunta> preguntasMezcladas = new ArrayList<>();
        preguntasMezcladas.add(proximaPregunta);
        this.preguntas.remove(proximaPregunta);
        Pregunta ultimaPregunta = proximaPregunta;
        while (!(this.preguntas.isEmpty())) {
            proximaPregunta = this.obtenerUnaPreguntaPorPosicion();
            if (!verificarPreguntasRestantes()) {
                while (proximaPregunta.obtenerTema().equals(ultimaPregunta.obtenerTema())) {
                    proximaPregunta = this.obtenerUnaPreguntaPorPosicion();
                }
            }
            preguntasMezcladas.add(proximaPregunta);
            this.preguntas.remove(proximaPregunta);
            ultimaPregunta = proximaPregunta;
        }
        return preguntasMezcladas;
    }
}