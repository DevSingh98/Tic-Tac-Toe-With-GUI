module deveshwar.singh.tictictactoegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens deveshwar.singh.tictictactoegame to javafx.fxml;
    exports deveshwar.singh.tictictactoegame;
}