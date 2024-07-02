package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoiceParcial;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionMultipleChoiceParcial extends CheckBox {
    private String opcion;
    private int indice;

    public BotonOpcionMultipleChoiceParcial(String opcion, int indice, ControladorEnviarMultipleChoiceParcial controladorRespondioUsuario) {
        this.opcion = opcion;
        this.indice = indice + 1;
        super.setText(opcion);
        super.setFont(Font.font(Estilos.FUENTE, 20));
        super.setTextFill(Color.BLACK);

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