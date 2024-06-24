package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public interface ParserRespuesta {
    public Respuesta parsearRespuesta(JsonObject jsonObject);
}
