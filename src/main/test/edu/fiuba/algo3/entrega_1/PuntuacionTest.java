package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Puntuacion.Puntuacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuacionTest {


    @Test
    public void Test01CreoUnaPuntuacionYPidoElTotalDePuntosGuardados() {
        Puntuacion puntuacion = new Puntuacion();


        assertEquals(0,puntuacion.obtenerPuntos() );

    }
    @Test
    public void Test02CreoUnaPuntuacionLeAgrego100puntosYMenosCincuentaPuntosLuegoPidoTotalPuntos() {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPuntos(100);
        puntuacion.agregarPuntos(-50);

        assertEquals(50,puntuacion.obtenerPuntos() );

    }
    @Test
    public void Test03CreoUnaPuntuacionLeAgregoMenosCienpuntosYAgregoCincuentaPuntosLuegoPidoTotalPuntos() {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPuntos(-100);
        puntuacion.agregarPuntos(50);

        assertEquals(-50,puntuacion.obtenerPuntos() );

    }

    @Test
    public void Test04CreoUnaPuntuacionYLeAgregoPuntosNegativos() {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPuntos(-100);
        puntuacion.agregarPuntos(-250);
        puntuacion.agregarPuntos(-750);
        int puntuacionEsperada = -1100;

        assertEquals(puntuacionEsperada,puntuacion.obtenerPuntos() );

    }

}
