module com.edu.espol.entrega {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.edu.espol.entrega to javafx.fxml;
    exports com.edu.espol.entrega;
    
     opens ec.edu.espol.Controller to javafx.fxml;
    exports ec.edu.espol.Controller;
}
