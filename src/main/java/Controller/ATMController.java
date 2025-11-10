package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ATMController {

    @FXML
    private StackPane contentArea;
    @FXML
    private Button backToDashboardBtn;

    @FXML
    protected void handleAbono(ActionEvent event) {
        System.out.println(" Botón 'Realizar Abono' presionado. Procesando abono de préstamo...");
    }

    @FXML
    protected void handleTransfer(ActionEvent event) {

        System.out.println("Botón 'Confirmar Transferencia' presionado. Procesando transferencia...");
    }


    private void loadView(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/" + fxmlFileName));
            Parent view = loader.load();

            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista: " + fxmlFileName);
        }
    }

    @FXML
    protected void onBackToDashboardButtonClick(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/Dashboard-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Control Principal");
            stage.setWidth(800);
            stage.setHeight(600);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista del Dashboard.");
        }
    }

    @FXML
    protected void showCuenta() {
        System.out.println("Cargando vista de Cuenta");
        loadView("Account-view.fxml");
    }

    @FXML
    protected void showTransferencias() {
        System.out.println("Cargando vista de Transferencias");
        loadView("Transfers-view.fxml");
    }

    @FXML
    protected void showPrestamos() {
        System.out.println("Cargando vista de Préstamos");
        loadView("Loans-view.fxml");
    }

    @FXML
    protected void showDeuda() {
        System.out.println("Cargando vista de Deuda financiera");
        loadView("Debt-view.fxml");
    }

    @FXML
    protected void showMovimientos() {
        System.out.println("Cargando vista de Movimientos recientes");
        loadView("Movements-view.fxml");
    }
}