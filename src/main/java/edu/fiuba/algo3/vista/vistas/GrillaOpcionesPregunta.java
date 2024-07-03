package edu.fiuba.algo3.vista.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class GrillaOpcionesPregunta extends GridPane {

    public GrillaOpcionesPregunta(int anchoPrimeraColumna, int anchoSegundaColumna) {
        super.setMaxWidth(600);
        super.getColumnConstraints().add(new ColumnConstraints(anchoPrimeraColumna));
        super.getColumnConstraints().add(new ColumnConstraints(anchoSegundaColumna));
        super.setAlignment(Pos.CENTER);
    }
}
