package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class RespuestaController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private ImageView img;

    @FXML
    private Label lbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Mostrar la imagen y el resultado
        mostrarResultado();

        btnBack.setOnAction(e -> {
            try {
                App.setRoot("principal");
            } catch (IOException ex) {
                // Manejar la excepción
            }
        });
    }
private void mostrarResultado() {
    String resultado = obtenerResultado(); // Obtener el resultado final
    lbl.setText("El animal que estás pensando es: " + resultado);

    try {
        Image gif = new Image(new FileInputStream(App.pathGif + "bien.gif"));
        img.setImage(gif);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}


   private String obtenerResultado() {
    return App.animalIdentificado; // Devuelve el resultado almacenado
}

}
