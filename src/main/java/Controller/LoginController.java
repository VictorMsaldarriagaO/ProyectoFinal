package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    private static final String VALID_ADMIN = "admin";
    private static final String VALID_PASS_A = "1234";
    private static final String VALID_USER = "juan";
    private static final String VALID_PASS = "4321";

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(VALID_ADMIN) && password.equals(VALID_PASS_A)) {
            messageLabel.setText("Inicio de sesión exitoso!");

            loadDashboard(event);
        } else if (username.equals(VALID_USER) && password.equals(VALID_PASS)) {

            messageLabel.setText("Inicio de sesión exitoso!");

            loadUserATM(event);
        } else {
            messageLabel.setText("Usuario o contraseña incorrectos.");
            passwordField.clear();
        }
    }

    @FXML
    protected void handleBackButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/Main-view.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Bienvenido al Banco");
            stage.setWidth(600);
            stage.setHeight(400);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error al cargar el menú principal.");
        }
    }

    private void loadDashboard(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/Dashboard-view.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Control");
            stage.setWidth(800);
            stage.setHeight(600);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error al cargar el Dashboard.");
        }
    }
    private void loadUserATM(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/ATM-view.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Control");
            stage.setWidth(800);
            stage.setHeight(600);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error al cargar el Dashboard.");
        }
    }
}