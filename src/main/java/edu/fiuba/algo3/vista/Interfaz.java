package edu.fiuba.algo3.vista;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Interfaz extends Application {

    @Override

    public void start(Stage primaryStage) {
        // Crear el componente de texto
        String texto = "El punto de ebullición del agua a 3300m del mar es 100 grados centígrados.";

        int maxLongitud = 34;
        // Texto truncado
        Text part1 = new Text(texto.substring(0,maxLongitud));
        Text part2 = new Text(texto.substring(maxLongitud));
        // Crear un TextFlow para contener ambas partes del texto
        TextFlow textFlow = new TextFlow(part1, new Text("\n"), part2);
        //Label label = new Label(truncatedText);
        //label.setPadding(new Insets(20));
        // Crear los botones
        Button button1 = new Button("Verdaero");
        button1.setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, CornerRadii.EMPTY, null)));
        button1.setTextFill(Color.WHITE);
        Button button2 = new Button("Falso");
        button2.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, null)));
        button2.setTextFill(Color.WHITE);

        Button siguiente = new Button("Siguiente");
        button1.setPrefSize(100, 50);
        button2.setPrefSize(100, 50);
        siguiente.setPrefSize(100, 50);

        // Crear un HBox para los botones con espaciado entre ellos
        HBox buttonBox = new HBox(60); // 10 píxeles de espaciado entre los botones
        buttonBox.getChildren().addAll(button1, button2);

        // Crear un VBox para el texto y los botones
        VBox vBox = new VBox(40); // 20 píxeles de espaciado entre el texto y el HBox
        vBox.setPadding(new Insets(20)); // 20 píxeles de padding alrededor del VBox
        vBox.getChildren().addAll(textFlow, buttonBox,siguiente);
        // Cambiar la fuente del Label a Arial, tamaño 24, negrita
        //textFlow.setRotate(Font.font("Arial", FontWeight.BOLD, 13).getSize());

        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vBox.setBackground(background);

        // Crear un StackPane como contenedor raíz
        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        // Crear la escena con el VBox y establecerla en el escenario
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Juego de preguntas");

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
