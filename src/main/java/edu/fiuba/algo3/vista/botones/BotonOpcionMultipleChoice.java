package edu.fiuba.algo3.vista.botones;
/*
import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionMultipleChoice extends CheckBox {

    private String opcion;

    public BotonOpcionMultipleChoice(String opcion, ControladorEnviarMultipleChoice controladorRespondioUsuario) {
        this.opcion = opcion;
        super.setText(opcion);
        super.setFont(Font.font(Estilos.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        Insets padding = new Insets(6, 6, 6, 6);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Tooltip tooltip = new Tooltip(opcion); // esto hace que en caso de que se corte salga el mensaje completo cuando posa el cursor por encima
        Tooltip.install(this, tooltip);
        super.setBackground(new Background(new BackgroundFill(Color.valueOf(Estilos.VIOLETA), bordeRedondeado, null)));
        super.setPadding(padding);
        super.selectedProperty().addListener((valorObservado, valorViejo, valorNuevo) -> {
            if (valorNuevo) {
                controladorRespondioUsuario.agregarOpcion(opcion);
            } else {
                controladorRespondioUsuario.eliminarOpcion(opcion);
            }
        });
    }
}*/

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionMultipleChoice extends CheckBox {

    private String opcion;
    private int indice;

    public BotonOpcionMultipleChoice(String opcion, int indice, ControladorEnviarMultipleChoice controladorRespondioUsuario) {
        this.opcion = opcion;
        this.indice = indice;
        super.setText(opcion);
        super.setFont(Font.font(Estilos.FUENTE, 20));
        super.setTextFill(Color.WHITE);

        // Ajustar el tamaño del CheckBox para que muestre el texto completo
        super.setMaxWidth(Double.MAX_VALUE);
        super.setWrapText(true);

        // Agregar un tooltip para mostrar el texto completo al pasar el cursor
        Tooltip tooltip = new Tooltip(opcion);
        Tooltip.install(this, tooltip);

        Insets padding = new Insets(6, 6, 6, 6);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        super.setBackground(new Background(new BackgroundFill(Color.valueOf(Estilos.VIOLETA), bordeRedondeado, null)));
        super.setPadding(padding);

        super.selectedProperty().addListener((valorObservado, valorViejo, valorNuevo) -> {
            if (valorNuevo) {
                controladorRespondioUsuario.agregarOpcion(indice + 1);
            } else {
                controladorRespondioUsuario.eliminarOpcion(indice + 1);
            }
        });
    }
}

