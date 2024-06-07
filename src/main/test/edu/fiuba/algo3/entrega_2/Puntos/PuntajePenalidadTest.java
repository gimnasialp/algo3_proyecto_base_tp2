package edu.fiuba.algo3.entrega_2.Puntos;

import edu.fiuba.algo3.tp2.modelo.PuntajePenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajePenalidadTest {

    @Test
    public void test01PuntajePenalidadPuntua1ConUnAciertoYNingunError(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(1, tipoPuntaje.puntuar(1,0));
    }

    @Test
    public void test02PuntajePenalidadPuntua3ConTresAciertosYNingunError(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(3, tipoPuntaje.puntuar(3,0));
    }

    @Test
    public void test03PuntajePenalidadPuntuaMenos3ConNingunAciertoYTresErrores(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(-3, tipoPuntaje.puntuar(0,3));
    }

    @Test
    public void test04PuntajePenalidadPuntua1ConTresAciertosYDosErrores(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(1, tipoPuntaje.puntuar(3,2));
    }

    @Test
    public void test05PuntajePenalidadPuntuaPuntua0ConNingunAciertoYNingunError(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(0, tipoPuntaje.puntuar(0,0));
    }
}
