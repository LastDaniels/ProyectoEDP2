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
import java.util.List;
import java.util.Map;
import controllers.App;

public class ComparadorDeRespuestas {

    public void compararRespuestas(NodoArbol nodo, HashMap<String, ArrayList<String>> respuestas, ArrayList<String> respuestasJugador, int indice) {
    if (nodo == null) {
        return;
    }

    // Comprobamos que no se acceda a un índice fuera de los límites
    if (indice >= respuestasJugador.size()) {
        verificarCoincidencia(respuestas, respuestasJugador);
        return;
    }

    if (respuestasJugador.get(indice).equals("sí")) {
        if (nodo.nodoSi != null) {
            compararRespuestas(nodo.nodoSi, respuestas, respuestasJugador, indice + 1);
        } else {
            verificarCoincidencia(respuestas, respuestasJugador);
        }
    } else {
        if (nodo.nodoNo != null) {
            compararRespuestas(nodo.nodoNo, respuestas, respuestasJugador, indice + 1);
        } else {
            verificarCoincidencia(respuestas, respuestasJugador);
        }
    }
}

 private void verificarCoincidencia(HashMap<String, ArrayList<String>> respuestas, ArrayList<String> respuestasJugador) {
    List<String> posiblesAnimales = new ArrayList<>();

    for (Map.Entry<String, ArrayList<String>> entry : respuestas.entrySet()) {
        String animal = entry.getKey();
        ArrayList<String> respuestasAnimal = entry.getValue();

        boolean coincide = true;
        for (int i = 0; i < respuestasJugador.size(); i++) {
            if (!respuestasJugador.get(i).equals(respuestasAnimal.get(i))) {
                coincide = false;
                break;
            }
        }

        if (coincide) {
            posiblesAnimales.add(animal);
        }
    }

    if (posiblesAnimales.size() == 1) {
        App.animalIdentificado = posiblesAnimales.get(0); // Guarda el resultado en la variable global
    } else if (posiblesAnimales.isEmpty()) {
        App.animalIdentificado = "No se encontró ningún animal que coincida con tus respuestas.";
    } else {
        App.animalIdentificado = "No se pudo determinar con certeza, pero los posibles animales son: " + String.join(", ", posiblesAnimales);
    }
}

}
