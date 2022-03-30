module kalkulator.kalkulatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab.calculator to javafx.fxml;
    exports com.lab.calculator;
}