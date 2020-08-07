module com.mycompany.examenits {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.examenits to javafx.fxml;
    exports com.mycompany.examenits;
}
