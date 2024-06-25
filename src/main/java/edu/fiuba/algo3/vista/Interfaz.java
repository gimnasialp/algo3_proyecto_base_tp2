package edu.fiuba.algo3.vista;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Interfaz extends Application {
    //private Stage primaryStage;
    @Override

    public void start(Stage primaryStage) {
        //this.primaryStage = primaryStage;
        //Creating nodes
        primaryStage.setTitle("Juego de preguntas");
        TextField textField1 = new TextField("");
        TextField textField2 = new TextField("");
        //Creating labels
        Label label1 = new Label("Nombre del 1ª jugador: ");
        label1.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        label1.setTextFill(Color.WHITE);
        Label label2 = new Label("Nombre del 2ª jugador: ");
        label2.setTextFill(Color.WHITE);
        label2.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        label2.setTranslateX(50);
        textField2.setTranslateX(30);
        textField1.setTranslateX(-15);
        HBox hvox = new HBox(20);
        hvox.setPadding(new Insets(50, 10 , 10, 30));
        hvox.getChildren().addAll(label1,textField1,label2,textField2);
        // Crear el botón y configurar su acción
        Button btnNext = new Button("Siguiente");
        btnNext.setPrefSize(100, 50);
        btnNext.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        btnNext.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        btnNext.setTranslateY(250);
        btnNext.setTranslateX(700);
        btnNext.setOnAction(event -> showFirstInterface(primaryStage));

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(hvox,btnNext);
        vbox.setPadding(new Insets(20));

        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKVIOLET, new CornerRadii(5), Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vbox.setBackground(background);
        Scene firstScene = new Scene(vbox, 900, 500);

        primaryStage.setTitle("Juego de preguntas");
        //

        primaryStage.setScene(firstScene);

        primaryStage.show();
    }

    private void showFirstInterface(Stage stage) {


        // Crear el componente de texto
        String texto = "El punto de ebullición del agua a 3300m del mar es 100 grados centígrados.";

        // Texto truncado
        Text part1 = new Text(texto);
        part1.setFont(Font.font("Verdana", FontWeight.BOLD,15));
        part1.setFill(Color.WHITE);

        //Label label = new Label(truncatedText);
        //label.setPadding(new Insets(20));
        // Crear los botones
        CheckBox checkBox1 = new CheckBox("Verdadero");
        checkBox1.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox1.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox1.setTextFill(Color.BLACK);

        CheckBox checkBox2 = new CheckBox("Falso");
        checkBox2.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox2.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox2.setTextFill(Color.BLACK);

        Button siguiente = new Button("Siguiente");
        siguiente.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        siguiente.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        siguiente.setTranslateY(60);
        siguiente.setTextFill(Color.BLACK);

        checkBox1.setPrefSize(200, 50);
        checkBox2.setPrefSize(200, 50);
        siguiente.setPrefSize(100, 50);

        // Crear un HBox para los botones con espaciado entre ellos
        HBox buttonBox = new HBox(250); // 10 píxeles de espaciado entre los botones
        buttonBox.getChildren().addAll(checkBox1, checkBox2);

        // Crear un VBox para el texto y los botones
        VBox vBox = new VBox(80); // 20 píxeles de espaciado entre el texto y el HBox
        //vBox.setPadding(new Insets(20)); // 20 píxeles de padding alrededor del VBox
        vBox.setPadding(new Insets(40,40,40,40));
        vBox.getChildren().addAll(part1, buttonBox,siguiente);
        // Cambiar la fuente del Label a Arial, tamaño 24, negrita
        //textFlow.setRotate(Font.font("Arial", FontWeight.BOLD, 13).getSize());

        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKVIOLET, new CornerRadii(5), Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vBox.setBackground(background);

        // Crear un StackPane como contenedor raíz
        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        // Crear la escena con el VBox y establecerla en el escenario
        Scene scene = new Scene(root, 900, 500);
        siguiente.setOnAction(event -> secondShow(stage));
        // Cambiar la escena de la ventana principal a la primera escena
        stage.setScene(scene);
    }

    private void secondShow(Stage stage){
        // Crear el componente de texto
        String texto = "¿Cuál es el disco más vendido de la historia?";

        // Texto truncado
        Text part1 = new Text(texto);
        part1.setFont(Font.font("Verdana", FontWeight.BOLD,15));
        part1.setFill(Color.WHITE);

        //Label label = new Label(truncatedText);
        //label.setPadding(new Insets(20));
        // Crear los botones
        CheckBox checkBox1 = new CheckBox("Revolver (Los Beatles)");
        checkBox1.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox1.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox1.setTextFill(Color.BLACK);

        CheckBox checkBox2 = new CheckBox("Greatest Hits (Queen)");
        checkBox2.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox2.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox2.setTextFill(Color.BLACK);

        CheckBox checkBox3 = new CheckBox("mp3 (Emilia)");
        checkBox3.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox3.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox3.setTextFill(Color.BLACK);

        CheckBox checkBox4 = new CheckBox("Thriller (Michael Jackson)");
        checkBox4.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox4.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox4.setTextFill(Color.BLACK);

        CheckBox checkBox5 = new CheckBox("Back to Black (Amy Winehouse)");
        checkBox5.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        checkBox5.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        checkBox5.setTextFill(Color.BLACK);

        Button siguiente = new Button("Siguiente");
        siguiente.setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, new CornerRadii(5), new Insets(-5,-5,-5,-5))));
        siguiente.setFont(Font.font("Verdana", FontWeight.BOLD,13));
        siguiente.setTranslateY(20);
        siguiente.setTranslateX(700);
        siguiente.setTextFill(Color.BLACK);

        checkBox1.setPrefSize(300, 40);
        checkBox2.setPrefSize(300, 40);
        checkBox3.setPrefSize(300,40);
        checkBox4.setPrefSize(300,40);
        checkBox5.setPrefSize(300,40);
        siguiente.setPrefSize(100, 40);

        // Crear un VBox para el texto y los botones
        VBox vBox = new VBox(40); // 20 píxeles de espaciado entre el texto y el HBox
        //vBox.setPadding(new Insets(20)); // 20 píxeles de padding alrededor del VBox
        vBox.setPadding(new Insets(40,40,40,40));
        vBox.getChildren().addAll(part1, checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,siguiente);



        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKVIOLET, new CornerRadii(5), Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vBox.setBackground(background);

        // Crear un StackPane como contenedor raíz
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        Scene secondScene = new Scene(root, 900, 600);
        stage.setScene(secondScene);

        // Crear el contenido de la segunda interfaz

        //Button btnBack = new Button("Atrás");
        siguiente.setOnAction(event -> stage.close());

        // Cambiar la escena de la ventana principal a la segunda escena

    }

    public static void main(String[] args){
        launch(args);
    }

}
