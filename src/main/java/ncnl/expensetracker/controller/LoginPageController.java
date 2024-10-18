package ncnl.expensetracker.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ncnl.expensetracker.config.SignoutHandler;
import ncnl.expensetracker.config.UserUtil;
import ncnl.expensetracker.model.User;
import ncnl.expensetracker.service.UserService;
import ncnl.expensetracker.views.FXMLView;

import java.util.Optional;

public class LoginPageController extends GenericController {

    @FXML
    private TextField loginsrcode;
    @FXML
    private PasswordField loginpassword;

    private final UserService userService = new UserService();

    @FXML
    public void userRegister(ActionEvent actionEvent) {
        try {
            fxmlManager.loadPage(FXMLView.SIGNUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void userExit(ActionEvent actionEvent) {
        SignoutHandler.handleExit();
    }

    @FXML
    protected void userLogin(ActionEvent actionEvent) {
        String srcode = loginsrcode.getText();
        String password = loginpassword.getText();

        User user = userService.authenticateUser(srcode, password);

        if (user != null) {
            System.out.println("Login successful! Redirecting to main page...");
            try {
                fxmlManager.loadPage(FXMLView.MAINDASHBOARD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid srcode or password. Please try again.");
            alert.showAndWait();

            UserUtil.clearFields(loginsrcode, loginpassword);
        }
    }

}
