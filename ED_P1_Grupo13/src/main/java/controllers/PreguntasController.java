package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import principal.ComparadorDeRespuestas;

public class PreguntasController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNo;

    @FXML
    private Button btnSi;

    @FXML
    private ImageView img;

    @FXML
    private Label lbl;

    private int preguntaActual = 0; // Índice de la pregunta actual
    private ArrayList<String> preguntas;
    private ArrayList<String> respuestasJugador; // Para almacenar las respuestas del jugador

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preguntas = App.preguntas; // Cargar la lista de preguntas
        respuestasJugador = new ArrayList<>(); // Inicializar la lista de respuestas

        mostrarPregunta(); // Mostrar la primera pregunta

        btnBack.setOnAction(e -> {
            try {
                App.setRoot("principal");
            } catch (IOException ex) {
                // Manejar la excepción
            }
        });

        btnSi.setOnAction(e -> {
            registrarRespuesta("sí");
        });

        btnNo.setOnAction(e -> {
            registrarRespuesta("no");
        });
    }

    private void mostrarPregunta() {
        if (preguntaActual < preguntas.size()) {
            lbl.setText(preguntas.get(preguntaActual)); // Mostrar la pregunta en la etiqueta
        } else {
            // Fin de las preguntas, realizar la lógica para adivinar el animal
            adivinarAnimal();
        }
    }

    private void registrarRespuesta(String respuesta) {
        respuestasJugador.add(respuesta); // Guardar la respuesta del jugador
        preguntaActual++; // Avanzar a la siguiente pregunta
        mostrarPregunta(); // Actualizar la vista
    }

private void adivinarAnimal() {
    ComparadorDeRespuestas comparador = new ComparadorDeRespuestas();
    comparador.compararRespuestas(App.arbolDePreguntas.getRaiz(), App.respuestas, respuestasJugador, 0);

    try {
        App.setRoot("respuesta"); // Cambia a la pantalla de respuesta
    } catch (IOException ex) {
        // Manejar la excepción
    }
}

}
