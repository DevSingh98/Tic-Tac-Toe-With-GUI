module deveshwar.singh.tictactoewithgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens deveshwar.singh.tictactoewithgui to javafx.fxml;
    exports deveshwar.singh.tictactoewithgui;
}