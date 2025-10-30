module com.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectofinal to javafx.fxml;
    exports com.example.proyectofinal;
    exports Model;
    opens Model to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
}