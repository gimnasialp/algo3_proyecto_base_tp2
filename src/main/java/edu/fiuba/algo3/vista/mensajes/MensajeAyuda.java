package edu.fiuba.algo3.vista.mensajes;


import edu.fiuba.algo3.Estilos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MensajeAyuda extends Label {
    public MensajeAyuda() {
        super("La aplicación consiste en un juego por turnos, de dos a cuatro jugadores, conformado por un " +
                "panel en el cual se mostrarán preguntas con múltiples opciones de respuesta. " +
                "Cada pregunta será mostrada N veces, una vez para cada jugador.\n" +
                "Existen distintos tipos de preguntas: verdadero/falso, múltiple choice, orden y grupos. \n" +
                "Cada tipo de pregunta asignará o restará puntos según las respuestas sean correctas o no. " +
                "Existen varios modificadores que se pueden usar una única vez. Los modificadores disponibles serán visibles para cada jugador:\n" +
                "\t- Multiplicadores: Cada jugador tendrá dos multiplicadores (un multiplicador “x2” y un multiplicador “x3”) " +
                "que podrá elegir utilizar en cualquiera de las preguntas “con penalidad”.\n" +
                "\t- Anulador: Cada jugador tendrá la opción de usar por única vez un “anulador de puntaje” " +
                "contra los otros jugadores. Al usarlo, si otro jugador acierta la pregunta, no recibirá " +
                "los puntos (Aplica a todos los otros jugadores).\n" +
                "\t- Exclusividad: Cada jugador tendrá dos opciones de “exclusividad de puntaje” que podrá elegir " +
                "utilizar en cualquiera de las preguntas que no tienen “penalidad”.\n" +
                "Por último, el juego finalizará cuando se llegue al límite preestablecido al comienzo del juego. Dicho límite puede ser " +
                "por cantidad de puntos máximos o por cantidad de preguntas.");
        super.setFont(Font.font(Estilos.FUENTE, 18));
        super.setTextFill(Color.YELLOW);
        super.setWrapText(true);
    }
}

