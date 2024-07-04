package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CirculoMultiplicador extends StackPane {

    public CirculoMultiplicador(Multiplicador multiplicador) {
        String textoBonus = "";
        if (multiplicador instanceof MultiplicarPorDos) {
            textoBonus = "X2";
        }
        if (multiplicador instanceof MultiplicarPorTres) {
            textoBonus = "X3";
        }
        Text textoCirculo = new Text(textoBonus);
        Circle circulo = new Circle(10, Paint.valueOf(Estilos.AMARILLO));
        super.getChildren().addAll(circulo, textoCirculo);

    }
}

