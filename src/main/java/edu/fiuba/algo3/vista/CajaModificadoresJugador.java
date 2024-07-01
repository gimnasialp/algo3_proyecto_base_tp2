package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class CajaModificadoresJugador extends HBox {

    private static int ESPACIADO_BONUS = 5;
    //private List<Modificador> modificadoresEspUsados;

    public CajaModificadoresJugador(Jugador jugador) {
        super(ESPACIADO_BONUS);
        super.setAlignment(Pos.CENTER);
        // modificadoresUsados = new ArrayList<>();
       //  modificadoresEspUsados = jugador.getModificadoresEspUsados();
       // crearCirculoExclusividad();
     //   crearCirculoAnulador();
        //crearCirculoMultiplicadorPorDos();
        //();
    }

    private void crearCirculoExclusividad(){
       // super.getChildren().add(new CirculoModificador(new ExclusividadDePuntaje()));
    }

    private void crearCirculoMultiplicadorPorDos(){
        //super.getChildren().add(new CirculoModificador(new MultiplicarPorDos()));
    }
    private void crearCirculoAnulador(){
       // super.getChildren().add(new CirculoModificador(new ExclusividadDePuntaje()));
    }
    private void crearCirculoMultiplicadorPorTres(){
       // super.getChildren().add(new CirculoModificador(new MultiplicarPorTres()));
    }


}
