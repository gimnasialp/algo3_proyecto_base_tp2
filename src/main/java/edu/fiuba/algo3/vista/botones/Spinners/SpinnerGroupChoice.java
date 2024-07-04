package edu.fiuba.algo3.vista.botones.Spinners;

import edu.fiuba.algo3.Estilos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.util.ArrayList;
import java.util.Map;

public class SpinnerGroupChoice extends HBox {

    private final String opcionSpinner;
    private final Spinner<String> spinner;


    public SpinnerGroupChoice(ArrayList<String> nombresGrupos, String opcion) {

        ObservableList<String> nombresGruposPosibles = FXCollections.observableArrayList();
        nombresGruposPosibles.addAll(nombresGrupos);

        spinner = new Spinner<>();
        opcionSpinner = opcion;

        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(nombresGruposPosibles);
        valueFactory.setValue(nombresGruposPosibles.get(0)); //valor por defecto

        spinner.setValueFactory(valueFactory);
        spinner.setMaxWidth(350);
        spinner.setMaxHeight(50);
        spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

        Label label = new Label(opcion);
        label.setFont(Font.font(Estilos.FUENTE, 25));
        label.setTextFill(Color.YELLOW);

        Insets padding = new Insets(4,4,4,4);// Proporciona un margen interior, mejora el aspecto y la disposición de la interfaz gráfica.
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color colorTransparente = Color.web(Estilos.VIOLETA,Estilos.ALPHA_OPCIONES);
        spinner.setBackground(new Background(new BackgroundFill(colorTransparente,bordeRedondeado,null)));
        spinner.setPadding(padding);
        label.setBackground(new Background(new BackgroundFill(colorTransparente,bordeRedondeado,null)));
        label.setPadding(padding);

        super.setAlignment(Pos.CENTER);
        super.setSpacing(2);
        super.getChildren().addAll(spinner, label);
    }

    public String getGrupoOpcion(){
        return spinner.getValue();
    }

    public String getOpcionSpinner() { return opcionSpinner;}
}

