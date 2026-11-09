module com.egc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.egc to javafx.fxml;
    exports com.egc;
}
