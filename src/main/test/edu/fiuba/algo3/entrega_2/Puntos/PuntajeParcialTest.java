package edu.fiuba.algo3.entrega_2.Puntos;

import edu.fiuba.algo3.tp2.modelo.PuntajeParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {

    @Test
    public void test01PuntajeParcialPuntua1ParaUnAciertoYNingunError(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(1, tipoPuntaje.puntuar(1,0));
    }

    @Test
    public void test02PuntajeParcialPuntua3ConTresAciertosYNingunError(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(3, tipoPuntaje.puntuar(3,0));
    }

    @Test
    public void test03PuntajeParcialPuntua0ConNingunAciertoYUnError() {
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(0, 1));
    }

    @Test
    public void test04PuntajeParcialPuntua0ConUnAciertoYTresErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(1,3));
    }

    @Test
    public void test05PuntajeParcialPuntua0ConNingunAciertoYNingunError(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(0,0));
    }
}
