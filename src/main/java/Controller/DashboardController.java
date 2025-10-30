package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onRegisterClientButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/ClientRegistration-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Panel de Control");
            stage.setScene(new Scene(root, 600, 800));
            stage.show();

            welcomeText.setText("Abriendo formulario de registro...");

        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("Error al cargar la vista de registro.");
        }
    }

    @FXML
    protected void onViewClientsButtonClick() {
        welcomeText.setText("Función para ver clientes no implementada aún.");
    }

    @FXML
    protected void onLoanManagementButtonClick() {
        welcomeText.setText("Función para gestión de préstamos no implementada aún.");
    }
}