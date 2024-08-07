package edu.fiuba.algo3.vista.botones.Spinners;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SpinnerOrderedChoice extends HBox {

    private final static int PRIMER_POSICION = 1;
    private final static int VALOR_INICIAL_SPINNER = 1;
    private Label label;
    private Spinner<Integer> spinner;

    public SpinnerOrderedChoice(String opcion, int cantidadOpciones, ControladorEnviarOrderedChoice controlador) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(PRIMER_POSICION, cantidadOpciones, VALOR_INICIAL_SPINNER);

        Spinner<Integer> spinner = new Spinner<>();
        spinner.setValueFactory(valueFactory);
        spinner.setMaxWidth(50);
        spinner.setMaxHeight(50);
        spinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);

        Label label = new Label(opcion);
        label.setFont(Font.font(Estilos.FUENTE, 20));
        label.setTextFill(Color.BLACK);

        Insets padding = new Insets(6, 6, 6, 6);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color colorTransparente = Color.web(Estilos.GRIS, Estilos.ALPHA_OPCIONES);
        spinner.setBackground(new Background(new BackgroundFill(colorTransparente, bordeRedondeado, null)));
        label.setBackground(new Background(new BackgroundFill(colorTransparente, bordeRedondeado, null)));
        label.setPadding(padding);

        this.label = label;
        this.spinner = spinner;
        super.setAlignment(Pos.CENTER);
        super.setSpacing(5);
        super.getChildren().addAll(spinner, label);
    }

    public int getNumeroOrden() {
        return spinner.getValue();
    }

    public String getEnunciadoOpcion() {
        return label.getText();
    }
}

