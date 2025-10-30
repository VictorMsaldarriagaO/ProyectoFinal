package Controller;

import Model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

        Client newClient = new Client(name, age, id, mail, phone);

        System.out.println("Nuevo Cliente Registrado:");
        System.out.println(newClient.toString());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro Exitoso");
        alert.setHeaderText(null);
        alert.setContentText("El cliente " + name + " ha sido registrado.");
        alert.showAndWait();

        nameField.clear();
        ageField.clear();
        idField.clear();
        mailField.clear();
        phoneField.clear();
    }
}