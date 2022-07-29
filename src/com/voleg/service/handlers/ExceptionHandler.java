package com.voleg.service.handlers;

import javafx.scene.control.Alert;

import java.io.FileNotFoundException;

public class ExceptionHandler {

    public static void handle(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText("Попробуйте снова.");

        if (exception instanceof NumberFormatException) {
            alert.setHeaderText("Вы ввели некорректные данные.");
        } else if (exception instanceof IllegalArgumentException) {
            alert.setHeaderText(exception.getMessage());
        } else if (exception instanceof FileNotFoundException) {
            alert.setHeaderText("Файл не был найден");
        }

        alert.showAndWait();
    }
}
