package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class UsuarioDashboardController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onOpenATMButtonClick(ActionEvent event) {
        try {
            welcomeText.setText("Abriendo Panel de Control del ATM...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/ATM-view.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Servicios Bancarios");
            stage.setWidth(800);
            stage.setHeight(600);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("Error al cargar la vista del ATM.");
        }
    }
}