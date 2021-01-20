package eg.edu.alexu.csd.oop.calculator.cs59;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setScene(new Scene(root, 350, 450));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
