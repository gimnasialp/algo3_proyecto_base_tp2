package edu.fiuba.algo3.modelo.Preguntas.VoF;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class VerdaderoFalsoConPenalidad extends VerdaderoFalso {

    public VerdaderoFalsoConPenalidad(String unEnunciado, ArrayList<Respuesta> unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta);
    }

    @Override
    public int evaluar(Respuesta respuesta) { return respuesta.valorConPenalidad(); }
}