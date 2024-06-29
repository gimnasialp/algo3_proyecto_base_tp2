package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.Modificador.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CirculoModificador  extends StackPane {

    public CirculoModificador(Modificador modificador) {
        String textoBonus = "";
        if(modificador instanceof ExclusividadDePuntaje){
            textoBonus = "E";
        }
        if(modificador instanceof MultiplicarPorTres){
            textoBonus = "x3";
        }
        if(modificador instanceof MultiplicarPorDos){

            textoBonus = "x2";
        }if(modificador instanceof AnuladorDePuntaje){
            textoBonus = "A";
        }
        Text textoCirculo = new Text(textoBonus);
        Circle circulo = new Circle(10, Paint.valueOf(Estilos.AMARILLO));
        super.getChildren().addAll(circulo,textoCirculo);

    }
}
