package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import controllers.App;
import principal.*;
import principal.ArbolDePreguntas;
/**
 * JavaFX App
 */
public class App extends Application {
    public static ArbolDePreguntas arbolDePreguntas; // Variable global para el árbol de preguntas
    public static String animalIdentificado = ""; // Variable para guardar el resultado
    private static Scene scene;
    public static String pathImg = "src/main/resources/images/";
    public static String pathGif = "src/main/resources/gifs/";
    public static String pathArchivos = "src/main/resources/archivos/";
    public static ArrayList<String> preguntas = Fichero.leerPreguntas(pathArchivos + "preguntas.txt");
    public static HashMap<String, ArrayList<String>> respuestas = Fichero.leerRespuestas(pathArchivos + "respuestas.txt");

    @Override
    public void start(Stage stage) throws IOException {
        arbolDePreguntas = new ArbolDePreguntas();
        arbolDePreguntas.construirArbol(preguntas);
        scene = new Scene(loadFXML("principal"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {
        launch();
        // Inicializar respuestas del jugador (simuladas)
        ArrayList<String> respuestasJugador = new ArrayList<>();
        respuestasJugador.add("si");
        respuestasJugador.add("no");
              

        

        
        Juego20Preguntas juego = new Juego20Preguntas(preguntas, respuestas);
        juego.iniciarJuego(respuestasJugador);

        System.out.print(preguntas.toString());
    }

    
}
