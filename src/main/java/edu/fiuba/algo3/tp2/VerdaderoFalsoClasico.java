package edu.fiuba.algo3.tp2;

import java.util.ArrayList;

public class VerdaderoFalsoClasico extends VerdaderoFalso {

    public VerdaderoFalsoClasico(String unEnunciado, ArrayList<Respuesta> unaRespuestaCorrecta) {
        super(unEnunciado, unaRespuestaCorrecta);
    }

    @Override
    public int evaluar(Respuesta respuesta) { return respuesta.valorClasico(); }
}
