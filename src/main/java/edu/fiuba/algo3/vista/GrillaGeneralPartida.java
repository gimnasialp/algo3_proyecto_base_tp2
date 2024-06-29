package edu.fiuba.algo3.vista;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GrillaGeneralPartida extends GridPane {


    private static final double DISTANCIA_FILAS = 20;
    private static final double TAM_ENCABEZADO = 110;
    private static final double TAM_CAJA_PREGUNTA = 300;
    private static final double TAM_BONUS = 70;
    private static final double TAM_BOTON_IR = 70;


    public GrillaGeneralPartida(double anchoPantalla, double altoPantalla) {

        super.setMinSize(anchoPantalla + 50, altoPantalla);
        super.setMaxSize(anchoPantalla + 50, altoPantalla);
        super.setVgap(DISTANCIA_FILAS);
        super.getRowConstraints().add(new RowConstraints(TAM_ENCABEZADO));
        super.getRowConstraints().add(new RowConstraints(TAM_CAJA_PREGUNTA));
        super.getRowConstraints().add(new RowConstraints(TAM_BONUS));
        super.getRowConstraints().add(new RowConstraints(TAM_BOTON_IR));
    }

}
