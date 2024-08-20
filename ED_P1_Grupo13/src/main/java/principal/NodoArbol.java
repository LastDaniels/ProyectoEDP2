/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Cecy
 */
class NodoArbol {
    String pregunta; // Almacena la pregunta o el nombre del animal
    NodoArbol nodoSi; // Subárbol para la respuesta "sí"
    NodoArbol nodoNo; // Subárbol para la respuesta "no"

    // Constructor para nodos de preguntas
    NodoArbol(String pregunta) {
        this.pregunta = pregunta;
        this.nodoSi = null;
        this.nodoNo = null;
    }

    // Constructor para nodos de animales (hojas)
    NodoArbol(String pregunta, NodoArbol nodoSi, NodoArbol nodoNo) {
        this.pregunta = pregunta;
        this.nodoSi = nodoSi;
        this.nodoNo = nodoNo;
    }
}
