module com.example.genericsfx1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.genericsfx1 to javafx.fxml;




    exports com.example.genericsfx1;
    exports com.example.genericsfx1.model;
    exports com.example.genericsfx1.util;
}