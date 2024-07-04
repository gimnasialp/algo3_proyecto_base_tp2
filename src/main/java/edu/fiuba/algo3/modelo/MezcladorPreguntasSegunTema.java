package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MezcladorPreguntasSegunTema implements MezcladorPreguntas {
    private ArrayList<Pregunta> preguntas;
    private Pregunta proximaPregunta;

    public MezcladorPreguntasSegunTema(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    private void obtenerUnaPreguntaPorPosicion() {
        Integer idProximaPreguntaProbable = (int) (Math.random() * this.preguntas.size());
        this.proximaPregunta = this.preguntas.get(idProximaPreguntaProbable);
    }

    private boolean verificarPreguntasRestantes() {
        String temaPregunta = this.preguntas.get(0).obtenerTema();
        List<Pregunta> preguntasConDistintoTema = this.preguntas.stream().filter(pregunta -> !(pregunta.obtenerTema().equals(temaPregunta))).collect(Collectors.toList());
        return preguntasConDistintoTema.isEmpty();
    }

    @Override
    public ArrayList<Pregunta> mezclarPreguntas() {
        this.obtenerUnaPreguntaPorPosicion();
        ArrayList<Pregunta> preguntasMezcladas = new ArrayList<>();
        preguntasMezcladas.add(proximaPregunta);

        this.preguntas = (ArrayList<Pregunta>) this.preguntas.stream().filter(pregunta -> !(pregunta.obtenerIdPregunta()==this.proximaPregunta.obtenerIdPregunta())).collect(Collectors.toList());

        String temaUltimaPregunta = proximaPregunta.obtenerTema();
        while (!(this.preguntas.isEmpty())) {
            this.obtenerUnaPreguntaPorPosicion();
            if (!verificarPreguntasRestantes()) {
                while (proximaPregunta.obtenerTema().equals(temaUltimaPregunta)) {
                    this.obtenerUnaPreguntaPorPosicion();
                }
            }
            preguntasMezcladas.add(proximaPregunta);
            this.preguntas = (ArrayList<Pregunta>) this.preguntas.stream().filter(pregunta -> !(pregunta.obtenerIdPregunta()==this.proximaPregunta.obtenerIdPregunta())).collect(Collectors.toList());
            temaUltimaPregunta = proximaPregunta.obtenerTema();
        }

        return preguntasMezcladas;
    }
}