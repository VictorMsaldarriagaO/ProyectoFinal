package Controller;

import Model.Client;
import Model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ClientRegistrationController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField idField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField phoneField;

    @FXML
    protected void onRegisterButtonClick() {
        String name = nameField.getText();
        String age = ageField.getText();
        String id = idField.getText();
        String mail = mailField.getText();
        String phone = phoneField.getText();

        if (name.trim().isEmpty() || age.trim().isEmpty() || id.trim().isEmpty()
                || mail.trim().isEmpty() || phone.trim().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error de Validación");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Por favor, complete todos los campos para registrar al cliente.");
            errorAlert.showAndWait();
            return;
        }

        Client newClient = new Client(name, age, id, mail, phone);

        String newAccountNumber = "C-" + (System.currentTimeMillis() % 10000);
        Account newAccount = new Account(newAccountNumber, newClient);
        newClient.setAccount(newAccount);

        ViewClientsControler.addClient(newClient);


        System.out.println("Nuevo Cliente Registrado:");
        System.out.println(newClient.toString());

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Registro Exitoso");
        successAlert.setHeaderText(null);
        successAlert.setContentText("El cliente " + name + " ha sido registrado con la cuenta N° " + newAccountNumber);
        successAlert.showAndWait();

        nameField.clear();
        ageField.clear();
        idField.clear();
        mailField.clear();
        phoneField.clear();
    }

    @FXML
    protected void onGoBackButtonClick(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}