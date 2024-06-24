package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorTeclaPresionada;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.VistaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(stage);

        VistaInicial vistaInicial = new VistaInicial(stage, pantallaPrincipal);
        pantallaPrincipal.setCentro(vistaInicial);
        Scene sceneInicio = new Scene(pantallaPrincipal, 1280, 720);
        sceneInicio.setOnKeyPressed(new ControladorTeclaPresionada(stage, pantallaPrincipal.getBarraDeMenu()));

        Image icono = new Image("file:" + System.getProperty("user.dir") + "src/main/java/edu/fiuba/algo3/resources/imagenes/icono.png");
        stage.getIcons().add(icono);
        stage.setScene(sceneInicio);
        stage.setMinWidth(1280);
        stage.setMinHeight(720);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}