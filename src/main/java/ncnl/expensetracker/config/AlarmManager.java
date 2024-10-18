package ncnl.expensetracker.config;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlarmManager {

    public static void showSuccessAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setHeaderText(null);
        alert.setContentText("User registered successfully!");
        alert.showAndWait();
    }

    public static void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Registration Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
