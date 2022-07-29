package com.voleg.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InstructionController {

    @FXML
    private Button okButton;

    @FXML
    void initialize() {
        okButton.setOnAction(actionEvent -> ((Stage) okButton.getScene().getWindow()).close());
    }
}
