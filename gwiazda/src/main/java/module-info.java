module com.example.trojkatikolko {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trojkatikolko to javafx.fxml;
    exports com.example.trojkatikolko;
}