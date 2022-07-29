package com.voleg.controller;

import java.io.File;
import java.io.IOException;

import com.voleg.service.OperationsImpl;
import com.voleg.service.handlers.ExceptionHandler;
import com.voleg.service.handlers.InputHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button clearButton;

    @FXML
    private CheckBox isToSaveCheckBox;

    @FXML
    private Button compButton;

    @FXML
    private TextField digitOneInputField;

    @FXML
    private Button digitOneSaveButton;

    @FXML
    private TextField digitTwoInputField;

    @FXML
    private Button digitTwoSaveButton;

    @FXML
    private Button divButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button instructionButton;

    @FXML
    private Text listField;

    @FXML
    private Button multButton;

    @FXML
    private Text operationResultField;

    @FXML
    private Button powButton;

    @FXML
    private TextField powerInputField;

    @FXML
    private Button sortButton;

    @FXML
    private Button subButton;

    @FXML
    private Button sumButton;

    private final OperationsImpl operations = new OperationsImpl();

    @FXML
    void initialize() {
        digitOneInputField.setOnKeyReleased(inputMethodEvent -> {
            try {
                operations.setX(InputHandler.fibDigitInputHandler(digitOneInputField));
            } catch (IllegalArgumentException exception) {
                ExceptionHandler.handle(exception);
            }
        });

        digitTwoInputField.setOnKeyReleased(inputMethodEvent -> {
            try {
                operations.setY(InputHandler.fibDigitInputHandler(digitTwoInputField));
            } catch (IllegalArgumentException exception) {
                ExceptionHandler.handle(exception);
            }
        });

        powerInputField.setOnKeyReleased(keyEvent -> {
            try {
                operations.setPower(InputHandler.powerDigitInputHandler(powerInputField));
            } catch (IllegalArgumentException exception) {
                ExceptionHandler.handle(exception);
            }
        });

        sumButton.setOnAction(actionEvent -> operationResultField.setText(operations.countSum()));

        subButton.setOnAction(actionEvent -> operationResultField.setText(operations.countSub()));

        multButton.setOnAction(actionEvent -> operationResultField.setText(operations.countMult()));

        divButton.setOnAction(actionEvent -> operationResultField.setText(operations.countDiv()));

        powButton.setOnAction(actionEvent -> operationResultField.setText(operations.countPow()));

        compButton.setOnAction(actionEvent -> operationResultField.setText(operations.compare()));

        digitOneSaveButton.setOnAction(actionEvent -> listField.setText(operations.save(operations.getX())));

        digitTwoSaveButton.setOnAction(actionEvent -> listField.setText(operations.save(operations.getY())));

        clearButton.setOnAction(actionEvent -> listField.setText(operations.clear()));

        sortButton.setOnAction(actionEvent -> listField.setText(operations.sort()));

        instructionButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/voleg/view/instruction.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage instructionStage = new Stage();
            instructionStage.setTitle("Инструкция");
            instructionStage.getIcons().add(new Image("com/voleg/resources/icons/calculator_icon_16px.png"));
            instructionStage.setScene(new Scene(loader.getRoot()));
            instructionStage.showAndWait();
        });

        isToSaveCheckBox.setOnAction(actionEvent -> {
            operations.setToSave(isToSaveCheckBox.isSelected());

            if (isToSaveCheckBox.isSelected()) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File("C:\\"));
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Выберите .txt файлы", "*.txt"));

                File historyFile = fileChooser.showOpenDialog(null);

                operations.setHistoryFile(historyFile);
            }
        });

        exitButton.setOnAction(actionEvent -> ((Stage) exitButton.getScene().getWindow()).close());
    }
}
