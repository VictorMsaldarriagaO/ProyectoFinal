package Controller;

import Model.Client;
import Model.Account;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewClientsControler implements Initializable {

    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> idColumn;
    @FXML
    private TableColumn<Client, String> ageColumn;
    @FXML
    private TableColumn<Client, String> mailColumn;
    @FXML
    private TableColumn<Client, String> phoneColumn;
    @FXML
    private TableColumn<Client, String> accountColumn;

    private static ObservableList<Client> clientListStatic = FXCollections.observableArrayList();
    private ObservableList<Client> clientList =clientListStatic;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (clientListStatic.isEmpty()) {
            loadDummyData();
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        accountColumn.setCellValueFactory(cellData -> {
            Client client = cellData.getValue();
            if (client.getAccount() != null) {
                return new SimpleStringProperty(client.getAccount().getnumAccount());
            } else {
                return new SimpleStringProperty("N/A");
            }
        });

        clientTable.setItems(clientList);
    }

    public static void addClient(Client newClient) {
        clientListStatic.add(newClient);
    }

    private void loadDummyData() {

        Client client1 = new Client("Ana Perez", "21", "1032988652", "ana.perez@mail.com", "3204387063");
        Client client2 = new Client("Juan Lopez", "22", "1032688787", "juan.lopez@mail.com", "3218917298");

        Account acc1 = new Account("C-1001", client1);
        acc1.deposited(800000);
        Account acc2 = new Account("C-1002", client2);
        acc2.deposited(900000);

        client1.setAccount(acc1);
        client2.setAccount(acc2);

        clientListStatic.add(client1);
        clientListStatic.add(client2);

    }

    @FXML
    protected void onGoBackButtonClick(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}