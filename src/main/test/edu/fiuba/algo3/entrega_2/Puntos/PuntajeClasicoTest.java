package edu.fiuba.algo3.entrega_2.Puntos;

import edu.fiuba.algo3.tp2.modelo.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {

    @Test
    public void test01PuntajeClasicoParaMultipleChoicePuntua1ParaVariosAciertosYNingunError() {
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(0, 1, 2));
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaMultipleChoice(opcionesCorrectas);
        assertEquals(1, tipoPuntaje.puntuar(3,0));
    }

    @Test
    public void test02PuntajeClasicoParaMultipleChoicePuntua0ParaVariosAciertosYUnError(){
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(0, 1, 2, 3));
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaMultipleChoice(opcionesCorrectas);
        assertEquals(0, tipoPuntaje.puntuar(3,1));
    }

    @Test
    public void test03PuntajeClasicoParaMultipleChoicePuntua0ParaNingunAciertoYUnError(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaVerdaderoFalso();
        assertEquals(0, tipoPuntaje.puntuar(0,1));
    }

    @Test
    public void test04PuntajeClasicoParaMultipleChoicePuntua1ParaUnAciertoYNingunError(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaVerdaderoFalso();
        assertEquals(1, tipoPuntaje.puntuar(1,0));
    }

    @Test
    public void test05PuntajeClasicoParaMultipleChoicePuntua0ParaNingunAciertoYNingunError(){
        PuntajeClasico tipoPuntaje = PuntajeClasico.ParaVerdaderoFalso();
        assertEquals(0, tipoPuntaje.puntuar(0,0));
    }
}
