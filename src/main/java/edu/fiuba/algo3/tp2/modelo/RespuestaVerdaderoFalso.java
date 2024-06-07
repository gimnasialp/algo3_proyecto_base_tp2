package edu.fiuba.algo3.tp2.modelo;


public class RespuestaVerdaderoFalso implements Respuesta {

    private final boolean respuesta;
    private Puntaje puntaje;

    public RespuestaVerdaderoFalso(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public static RespuestaVerdaderoFalso ConPuntaje(boolean respuesta, Puntaje puntaje) {
        RespuestaVerdaderoFalso miRespuestaVF = new RespuestaVerdaderoFalso(respuesta);
        miRespuestaVF.puntaje = puntaje;
        return miRespuestaVF;
    }

    public boolean equals(RespuestaVerdaderoFalso otraRespuesta) {
        return otraRespuesta.equals(respuesta);
    }

    private boolean equals(boolean otraRespuesta) {
        return respuesta == otraRespuesta;
    }

    @Override
    public Integer evaluar(Respuesta respuestaUsuario) {
        try {
            RespuestaVerdaderoFalso respuestaUsuarioCast = (RespuestaVerdaderoFalso) respuestaUsuario;
            int aciertos = this.equals(respuestaUsuarioCast) ? 1 : 0;
            int errores = 1 - aciertos;
            return puntaje.puntuar(aciertos, errores);
        } catch (RuntimeException e) {
            throw new RespuestaNoCompatibleException();
        }
    }

    @Override
    public boolean permiteMultiplicadores() {
        return puntaje.permiteMultiplicadores();
    }

    @Override
    public boolean permiteExclusividad() {
        return puntaje.permiteExclusividad();
    }

    @Override
    public Respuesta respuestaIncorrecta() {
        return new RespuestaVerdaderoFalso(!respuesta);
    }

}
