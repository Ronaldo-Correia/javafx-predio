package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.exception.TextFieldNumberFormatException;
import com.example.model.Andar;
import com.example.model.Predio;
import com.example.model.Sala;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    @FXML
    private TextField qtdAndares;

    private List<GridPane> grids;
    private List<TextField> vlMetro;

    @FXML
    private Button secondaryButton;

    @FXML
    private TabPane tabs;

    @FXML
    void addSala(ActionEvent event) {
        var grid = grids.get(tabs.getSelectionModel().getSelectedIndex());
        int row = grid.getRowCount();
        Label lblSala = new Label("Sala " + (row + 1) + ":");
        TextField txSala = new TextField();
        grid.add(lblSala, 1, row);
        grid.add(txSala, 2, row);
    }

    @FXML
    void calcular(ActionEvent event) {
        try {
            Predio predio = new Predio();
            for (int i = 0; i < grids.size(); i++) {
                Andar andar ;
                try {
                    andar = new Andar(Integer.valueOf(vlMetro.get(i).getText()));
                } catch (NumberFormatException e) {
                    throw new TextFieldNumberFormatException(vlMetro.get(i), tabs, i);
                }
                predio.addAndar(andar);
                for (Node node : grids.get(i).getChildren()) {
                    if (node instanceof TextField) {
                        try {
                            andar.addSala(new Sala(Integer.valueOf(((TextField) node).getText())));
                        } catch (NumberFormatException e) {
                            throw new TextFieldNumberFormatException(((TextField) node), tabs, i);                            
                        }
                    }
                }
                new Alert(AlertType.INFORMATION, String.format("Valor andar %d: %d",i + 1, andar.getValor())).showAndWait();
            }
            new Alert(AlertType.INFORMATION, String.format("Valor predio: %d",predio.getValor())).showAndWait();
        } catch (TextFieldNumberFormatException e) {
            new Alert(AlertType.ERROR, String.format("Favor informar apenas valores numéricos")).showAndWait();
            e.requestFocus();            
        }


    }

    @FXML
    void gerarAndares(ActionEvent event) {
        try {

            for (int i = 0; i < Integer.valueOf(qtdAndares.getText()); i++) {
                Tab tab = new Tab();
                tab.setText("Andar " + (i + 1));

                GridPane grid = new GridPane();
                grids.add(grid);

                Label lblValorMetro = new Label("Valor Metro");
                TextField txValorMetro = new TextField();
                vlMetro.add(txValorMetro);

                HBox footer = new HBox(lblValorMetro, txValorMetro);

                VBox vBox = new VBox(grid, footer);
                // vBox.
                tab.setContent(vBox);
                tabs.getTabs().add(tab);
            }
        } catch (NumberFormatException e) {
            new Alert(AlertType.ERROR, String.format("Favor informar apenas valores numéricos")).showAndWait();
            qtdAndares.requestFocus();
            qtdAndares.selectAll();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabs.getTabs().clear();
        grids = new ArrayList<>();
        vlMetro = new ArrayList<>();

    }

}