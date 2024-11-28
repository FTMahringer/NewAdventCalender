module htl.steyr.newadventcalender {
    requires javafx.controls;
    requires javafx.fxml;


    opens htl.steyr.newadventcalender to javafx.fxml;
    exports htl.steyr.newadventcalender;
}