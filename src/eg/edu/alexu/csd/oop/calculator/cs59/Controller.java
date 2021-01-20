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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.regex.*;
import java.awt.*;

public class Controller {

    private Calculator operations = new Operations(); boolean flag=false;

    @FXML
    private TextField result;

    @FXML
    private void getValue (ActionEvent event) {

        String input = ((Button)event.getSource()).getText();

        if (flag) {

            result.setText(input); flag=false;

        } else
            result.setText(result.getText() + input);

    }

    @FXML
    private void equal (ActionEvent event) {

        operations.input(result.getText());

        String str = operations.getResult();
        if (str != null)
            result.setText(str);
        else result.setText("Error");

        flag = true;

    }

    @FXML
    private void keyboard(javafx.scene.input.KeyEvent keyEvent) {

        if (!keyEvent.getCharacter().matches("^[\\.\\d\\*\\/\\-\\+]") && !keyEvent.getCode().equals(KeyCode.ENTER)) {

            result.deletePreviousChar();

        } else if (keyEvent.getCharacter().matches("^[\\.\\d\\*\\/\\-\\+]") && !keyEvent.getCode().equals(KeyCode.ENTER) && flag) {

            result.clear(); result.setText(keyEvent.getCharacter()); flag=false; result.forward();

        }

    }

    @FXML
    private void current(ActionEvent event) {

        String str = operations.current();
        if (str != null)  result.setText(str);
        else result.setText("Error");


    }

    @FXML
    private void prev(ActionEvent event) {

        String str = operations.prev();
        if (str != null)  result.setText(str);
        else result.setText("Error");

    }

    @FXML
    private void next(ActionEvent event) {

        String str = operations.next();
        if (str != null)  result.setText(str);
        else result.setText("Error");

    }

    @FXML
    private void save(ActionEvent event) throws IOException {

        operations.save();

    }

    @FXML
    private void load(ActionEvent event) throws IOException {

        operations.load();

    }

    @FXML
    private void delete(ActionEvent event) {

        if (result.getText() != "Error")
            result.setText( result.getText().substring(0, result.getText().length()-1));

    }

    @FXML
    private void AC(ActionEvent event) {

        result.clear();

    }

}