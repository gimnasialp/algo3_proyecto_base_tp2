package edu.fiuba.algo3.tp2.modelo;

public interface Respuesta {

    Integer evaluar(Respuesta respuestaUsuario);

    boolean permiteMultiplicadores();

    boolean permiteExclusividad();

    Respuesta respuestaIncorrecta();
}
