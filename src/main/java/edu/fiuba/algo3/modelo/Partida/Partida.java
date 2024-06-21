package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Puntaje;

public class Partida {

    private Limite limite;
    public void setearLimite(Limite limite) {
        this.limite = limite;
    }

    public Limite obtenerLimite() {
        return limite;
    }
}
