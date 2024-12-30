module com.example.pratica724 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pratica724 to javafx.fxml;
    exports com.example.pratica724;
    exports com.example.pratica724.utenti;
    opens com.example.pratica724.utenti to javafx.fxml;
    exports com.example.pratica724.auto;
    opens com.example.pratica724.auto to javafx.fxml;
}