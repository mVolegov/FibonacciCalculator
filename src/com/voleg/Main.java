package com.voleg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/main_window.fxml"));

        primaryStage.setTitle("Калькулятор");
        primaryStage.getIcons().add(new Image("com/voleg/resources/icons/calculator_icon_16px.png"));
        primaryStage.setScene(new Scene(root, 650, 700));
        primaryStage.show();
    }
}
