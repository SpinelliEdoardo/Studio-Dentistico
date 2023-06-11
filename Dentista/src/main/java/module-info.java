module com.example.dentista.dentista {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dentista.dentista to javafx.fxml;
    exports com.example.dentista.dentista;
}