package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

    public VerdaderoFalsoClasico(String unEnunciado, ArrayList<Respuesta> unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta);
    }

    @Override
    public int evaluar(Respuesta respuesta) { return respuesta.valorClasico(); }
}