package edu.fiuba.algo3.vista;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Interfaz extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un label con una oración
        Label sentenceLabel = new Label("Argentina campeon del mundo?.");

        // Crear los dos botones con medidas específicas
        Button button1 = new Button("Verdadero");
        button1.setPrefSize(100, 50); // Establecer el tamaño del botón izquierdo

        Button button2 = new Button("Falso");
        button2.setPrefSize(100, 50); // Establecer el tamaño del botón derecho

        // Añadir acción a los botones
        button1.setOnAction(event -> System.out.println("Botón Izquierdo presionado"));
        button2.setOnAction(event -> System.out.println("Botón Derecho presionado"));

        // Crear un HBox para el botón izquierdo y configurarlo
        HBox leftBox = new HBox(button1);
        leftBox.setPadding(new javafx.geometry.Insets(10)); // Añadir padding
        leftBox.setPrefWidth(150); // Ancho preferido del contenedor izquierdo

        // Crear un HBox para el botón derecho y configurarlo
        HBox rightBox = new HBox(button2);
        rightBox.setPadding(new javafx.geometry.Insets(10)); // Añadir padding
        rightBox.setPrefWidth(150); // Ancho preferido del contenedor derecho

        // Crear un BorderPane y añadir los componentes
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(sentenceLabel); // Colocar el label en la parte superior
        borderPane.setLeft(leftBox); // Colocar el contenedor del botón izquierdo en el lado izquierdo
        borderPane.setRight(rightBox); // Colocar el contenedor del botón derecho en el lado derecho

        // Crear la escena con el BorderPane
        Scene scene = new Scene(borderPane, 400, 200); // Tamaño de la ventana 400x200 píxeles

        // Configurar el escenario (Stage)
        primaryStage.setTitle("Juego de responder Preguntas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
