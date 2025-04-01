module deveshwar.singh.tictactoewithgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    opens deveshwar.singh.tictactoewithgui to javafx.fxml;
    exports deveshwar.singh.tictactoewithgui;
}