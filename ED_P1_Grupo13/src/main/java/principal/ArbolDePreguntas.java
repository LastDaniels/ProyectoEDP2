/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Cecy
 */
import java.util.*;
import java.util.HashMap;

public class ArbolDePreguntas {
    NodoArbol raiz;

    public NodoArbol getRaiz() {
        return raiz;
    }
    
    // Método para construir el árbol
    public void construirArbol(ArrayList<String> preguntas) {
        raiz = construirSubArbol(preguntas, 0);
    }

    // Método recursivo para construir un subárbol
    private NodoArbol construirSubArbol(ArrayList<String> preguntas, int indice) {
    if (indice >= preguntas.size()) {
        return null;
    }

    String pregunta = preguntas.get(indice);
    NodoArbol nodo = new NodoArbol(pregunta);

    nodo.nodoSi = construirSubArbol(preguntas, indice + 1); 
    nodo.nodoNo = construirSubArbol(preguntas, indice + 2); 

    return nodo;
}

}
