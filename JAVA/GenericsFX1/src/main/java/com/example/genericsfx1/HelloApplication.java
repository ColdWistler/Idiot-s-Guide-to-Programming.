package com.example.genericsfx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL fxmlLocation = getClass().getResource("/com/example/genericsfx1/MainView.fxml");
        if (fxmlLocation == null) {
            System.err.println("FXML file not found! Check path: /com/example/genericsfx1/MainView.fxml");
            return;
        }

        Parent root = FXMLLoader.load(fxmlLocation);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Generic Parcel Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}