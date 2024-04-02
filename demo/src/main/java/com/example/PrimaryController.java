package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txNome;

    @FXML
    private void switchToSecondary() throws IOException {
        new Alert(AlertType.INFORMATION, "Nome informado: "+txNome.getText()).showAndWait();

        //App.setRoot("secondary");
    }
}
