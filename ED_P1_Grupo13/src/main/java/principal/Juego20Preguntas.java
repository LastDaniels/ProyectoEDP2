/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Cecy
 */
import java.util.ArrayList;
import java.util.HashMap;
import controllers.*;

import controllers.App;
public class Juego20Preguntas {
    ArbolDePreguntas arbolDePreguntas;
    ComparadorDeRespuestas comparadorDeRespuestas;
    

    public Juego20Preguntas(ArrayList<String> preguntas, HashMap<String, ArrayList<String>> respuestas) {
        arbolDePreguntas = new ArbolDePreguntas();
        comparadorDeRespuestas = new ComparadorDeRespuestas();

        // Construir el árbol de preguntas
        arbolDePreguntas.construirArbol(preguntas);
    }

    public void iniciarJuego(ArrayList<String> respuestasJugador) {
        comparadorDeRespuestas.compararRespuestas(arbolDePreguntas.raiz,App.respuestas , respuestasJugador, 0);
    }
}
