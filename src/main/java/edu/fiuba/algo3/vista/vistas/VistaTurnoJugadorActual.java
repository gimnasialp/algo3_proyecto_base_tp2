package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonMultiplicador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class VistaTurnoJugadorActual extends VistaDinamicaJuego {
    private AlgoHoot algoHoot;
    private Partida partidaActual;
    private PreguntaMultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad;
    private PreguntaVerdaderoFalsoConPenalidad preguntaVerdaderoFalsoConPenalidad;

    public VistaTurnoJugadorActual(String nombreImagen, Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(nombreImagen, stage, pantallaPrincipal);
        this.algoHoot = algoHoot;
        this.partidaActual = algoHoot.obtenerPartidaActiva();

        GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);
        VBox cajaPregunta = crearContenedorPregunta(algoHoot.obtenerPartidaActiva().obtenerPreguntaActual());
       // HBox contenedorJugadores = crearContenedorJugadores(algoHoot.obtenerPartidaActiva().getJugadores());
        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);
        VBox cajaModificadores = crearCajaModificadores(stage, pantallaPrincipal);

        grilla.add(cajaPregunta, 0, 0);
        grilla.add(cajaModificadores, 0, 2);
        //grilla.add(botonConfirmado, 0, 2);
        grilla.setAlignment(Pos.CENTER);
        super.getChildren().add(grilla);

    }

    private VBox crearContenedorPregunta(Pregunta preguntaActual) {

        VBox contenedorPregunta = new VBox(ESPACIADO_CENTRAL);
        contenedorPregunta.setAlignment(Pos.TOP_CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(7)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        VBox vboxContenido = new VBox(7); // HBox para alinear el label y el textfield horizontalmente
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        Label tipoPreguntaActual = new Label("TIPO DE PREGUNTA: " + preguntaActual.ObtenerTipoPregunta());
        tipoPreguntaActual.setFont(Font.font(Estilos.FUENTE, 30));
        tipoPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));

        Label temaPreguntaActual = new Label("TEMA: " + preguntaActual.obtenerTema());
        temaPreguntaActual.setFont(Font.font(Estilos.FUENTE, 30));
        temaPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));


        vboxContenido.getChildren().addAll(tipoPreguntaActual, temaPreguntaActual);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        contenedorPregunta.getChildren().add(contenedor);


        return contenedorPregunta;
    }

/*

    private HBox crearCajaJugador(Jugador jugador) {
        CajaJugador cajaJugador = new CajaJugador(jugador, Estilos.AZUL);
        cajaJugador.setPrefSize(200, 300);
        return cajaJugador;
    }
*/

    private VBox crearCajaModificadores(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox cajaModificadores = new VBox(ESPACIADO_CENTRAL);
        cajaModificadores.setAlignment(Pos.CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(7)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        /*VBox vboxContenido = new VBox(7); // HBox para alinear el label y el textfield horizontalmente
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));*/

        HBox hboxUno = new HBox(25); // HBox para alinear 2 modificadores horizontalmente
        hboxUno.setAlignment(Pos.CENTER); // Alinear arriba y al centro
        hboxUno.setPadding(new Insets(5));

        /*HBox hboxDos = new HBox(50); // HBox para alinear
        hboxDos.setAlignment(Pos.CENTER); // Alinear abajo y al centro
        hboxDos.setPadding(new Insets(5));*/

        this.agregarModificadores(hboxUno);

        String nombreModificador;

        MultiplicarPorDos multiplicarPorDos = new MultiplicarPorDos();
        nombreModificador = "Usar Multiplicador x"+multiplicarPorDos.consultarValor();
        VBox botonMultiplicadorPorDos = crearBoton(nombreModificador);

        MultiplicarPorTres multiplicarPorTres = new MultiplicarPorTres();
        nombreModificador = "Usar Multiplicador x"+multiplicarPorTres.consultarValor();
        VBox botonMultiplicadorPorTres = crearBoton(nombreModificador);

        ExclusividadDePuntaje exclusividadDePuntaje = new ExclusividadDePuntaje();
        nombreModificador = "Usar Exclusividad de puntaje";
        VBox botonExclusividad = crearBoton(nombreModificador);

        AnuladorDePuntaje anuladorDePuntaje = new AnuladorDePuntaje();
        nombreModificador = "Usar Anulador de puntaje";
        VBox botonAnulador = crearBoton(nombreModificador);


        hboxUno.getChildren().addAll(botonMultiplicadorPorDos, botonMultiplicadorPorTres);
        //hboxDos.getChildren().addAll(botonExclusividad, botonAnulador);

        //vboxContenido.getChildren().addAll(hboxUno, hboxDos);

        // Añadir HBox interno al contenedor con fondo
        //contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        cajaModificadores.getChildren().add(contenedor);

        return cajaModificadores;
    }

    private void agregarModificadores(HBox hBox) {
        Jugador jugadorActivo = this.partidaActual.obtenerJugadorActivo();
        String nombreModificador;
        if (esPreguntaConPenalidad()) {
            for (Multiplicador multiplicador :jugadorActivo.obtenerMultiplicadoresDisponibles()) {
                nombreModificador = "Usar Multiplicador x"+multiplicador.consultarValor();
                VBox botonMultiplicador = crearBoton(nombreModificador);
                hBox.getChildren().add(botonMultiplicador);
            }
        }
        else {
            Modificador exclusividad = new ExclusividadDePuntaje();
            if (exclusividad)
            nombreModificador = "Usar exclusividad de puntaje";
        }

    }

    private boolean esPreguntaConPenalidad() {
        Pregunta pregunta = this.partidaActual.obtenerPreguntaActual();
        return pregunta.equals(preguntaMultipleChoiceConPenalidad) ||
                pregunta.equals(preguntaVerdaderoFalsoConPenalidad);
    }

    @Override
    protected VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        //no hace nada
        return new VBox();
    }

    private VBox crearBoton(String nombreModificador) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.CENTER);
        BotonMultiplicador botonMultiplicador = new BotonMultiplicador(nombreModificador);
        botonConfirmado.getChildren().add(botonMultiplicador);
        return botonConfirmado;
    }

/*
    private HBox crearBoton(Stage stage, PantallaPrincipal pantallaPrincipal) {
        HBox botonConfirmado = new HBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonMultiplicador botonMultiplicador = new BotonMultiplicador(new MultiplicarPorDos());
        botonConfirmado.getChildren().add(botonMultiplicador);
        return botonConfirmado;
    }*/

}
