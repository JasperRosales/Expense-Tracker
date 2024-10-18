package ncnl.expensetracker.config;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class SignoutHandler {
    public static void handleExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("You're about to exit the application.");
        alert.setContentText("Are you sure you want to exit?");

        ButtonType yesBtn= new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alert.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == yesBtn) {
            Platform.exit();
        } else {
            System.out.println("Exit canceled.");
        }
    }
}
