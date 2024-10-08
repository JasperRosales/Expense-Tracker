module saksinijava.expensetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens saksinijava.expensetracker to javafx.fxml;
    exports saksinijava.expensetracker;
}