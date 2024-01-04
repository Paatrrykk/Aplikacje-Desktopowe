module com.example.loginhaslo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginhaslo to javafx.fxml;
    exports com.example.loginhaslo;
}