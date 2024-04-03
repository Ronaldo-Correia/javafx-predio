package com.example.exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class TextFieldNumberFormatException extends Exception {

    private TextField textField;
    private TabPane tabPane;
    private int index;

    public TextFieldNumberFormatException(TextField textField) {
        this.textField = textField;
    }

    public TextFieldNumberFormatException(TextField textField, TabPane tabs, int index) {
        this(textField);
        this.tabPane = tabs;
        this.index = index;
    }

    public void requestFocus() {
        if(tabPane!= null){
            tabPane.getSelectionModel().select(index);
        }
        textField.requestFocus();
        textField.selectAll();
    }

}
