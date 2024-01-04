package com.example.loginhaslo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Text text1 = new Text("Email");

        Text text2 = new Text("Password");

        TextField textField1 = new TextField();

        PasswordField passwordField = new PasswordField();

        Button button1 = new Button("Submit");
        Button button2 = new Button("Clear");

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(400, 200);

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(button1, 0, 2);
        gridPane.add(button2, 1, 2);

        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        text1.setStyle("-fx-font: normal bold 20px 'serif' ");
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        javafx.scene.control.ProgressBar passwordStrength = new javafx.scene.control.ProgressBar();
        passwordStrength.setMaxWidth(Double.MAX_VALUE);
        passwordStrength.setMinHeight(20);
        passwordStrength.setStyle("-fx-accent: green;");

        passwordStrength.progressProperty().bind(passwordField.textProperty().length().divide(8.0));

        gridPane.add(passwordStrength, 1, 3);

        button1.setOnAction(e -> {
            String email = textField1.getText();
            String password = passwordField.getText();

            if (!isValidEmail(email)) {
                showAlert("Invalid email address");
                return;
            }

            if (password.length() < 8) {
                showAlert("Password should be at least 8 characters long");
                return;
            }

            showAlert("Submission successful");
        });

        Scene scene = new Scene(gridPane);

        stage.setTitle("Login and Password Form");

        stage.setScene(scene);

        stage.show();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String args[]) {
        launch(args);
    }
}

