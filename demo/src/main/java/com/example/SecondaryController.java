package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

public class SecondaryController implements Initializable {
    

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
        Label lblSala = new Label("Sala "+(row+1)+":");
        TextField txSala = new TextField();
        grid.add(lblSala, 1, row);
        grid.add(txSala, 2, row);
        //new Alert(AlertType.INFORMATION, "RowCount: "+grid.getRowCount()).showAndWait();
        

    }

    @FXML
    void calcular(ActionEvent event) {
        //OO
        Predio predio = new Predio();
        for (int i = 0; i < grids.size(); i++) {
            Andar andar = new Andar(Integer.valueOf(vlMetro.get(i).getText()));
            predio.addAndar(andar);            
            for (Node node : grids.get(i).getChildren()) {
                if (node instanceof TextField){
                    andar.addSala(new Sala(Integer.valueOf(((TextField)node).getText())));                    
                }
            }
            new Alert(AlertType.INFORMATION, "Valor andar "+(i+1)+": "+andar.getValor()).showAndWait();
        }
        new Alert(AlertType.INFORMATION, "Valor predio: "+predio.getValor()).showAndWait();

        try {
            switchToPrimary();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void gerarAndares(ActionEvent event) {        
        for (int i = 0; i < Integer.valueOf(qtdAndares.getText()); i++) {
            Tab tab = new Tab();
            tab.setText("Andar "+(i+1));
            
            
            GridPane grid = new GridPane();
            grids.add(grid);
                    
            Label lblValorMetro = new Label("Valor Metro");
            TextField txValorMetro = new TextField();
            vlMetro.add(txValorMetro);
            
            HBox footer = new HBox(lblValorMetro, txValorMetro);            
            
            
            
            VBox vBox = new VBox(grid, footer);
            //vBox.
            tab.setContent(vBox);
            tabs.getTabs().add(tab);
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabs.getTabs().clear();       
        grids = new ArrayList<>();
        vlMetro = new ArrayList<>();
    
    }


}