package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerGroupChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviarGroupChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {
    private ArrayList<Integer> respuestaGrupoUno;
    private ArrayList<Integer> respuestaGrupoDos;
    private ArrayList<SpinnerGroupChoice> spinnerGrupos;


    public ControladorEnviarGroupChoice(ArrayList<Integer> respuestaGrupoUno, ArrayList<Integer> respuestaGrupoDos, Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(stage, pantallaPrincipal, algoHoot);
        this.respuestaGrupoUno = respuestaGrupoUno;
        this.respuestaGrupoDos = respuestaGrupoDos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        agregarOpcionesSeleccionadas(spinnerGrupos);
        RespuestaGroupChoice respuestaDeUnJugador =  new RespuestaGroupChoice( respuestaGrupoUno, respuestaGrupoDos);
        definirSiguienteVista(respuestaDeUnJugador);
    }

    public void agregarSpinnersGrupo(ArrayList<SpinnerGroupChoice> spinnerGrupos){
        this.spinnerGrupos = spinnerGrupos;
    }

    public void agregarOpcionesSeleccionadas(ArrayList<SpinnerGroupChoice> spinnersGrupo) {
    }
}
