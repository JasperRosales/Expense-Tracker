package ncnl.expensetracker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ncnl.expensetracker.config.AlarmManager;
import ncnl.expensetracker.config.SignoutHandler;
import ncnl.expensetracker.config.UserUtil;
import ncnl.expensetracker.model.User;
import ncnl.expensetracker.service.UserService;
import ncnl.expensetracker.views.FXMLView;

public class SignupPageController extends GenericController {

    @FXML
    private TextField nameSignupTxt, gsuiteSignupTxt, departmentSignupTxt, roleSignupTxt, programSignupTxt;
    @FXML
    private PasswordField passwordSignupTxt;

    private final UserService userService = new UserService();

    @FXML
    public void userRegister(ActionEvent actionEvent) {
        String fullname = nameSignupTxt.getText();
        String gsuite = gsuiteSignupTxt.getText();
        String password = passwordSignupTxt.getText();
        String department = departmentSignupTxt.getText();
        String role = roleSignupTxt.getText();
        String program = programSignupTxt.getText();

        if (!UserUtil.isValidGsuiteEmail(gsuite)) {
            AlarmManager.showErrorAlert("Invalid gsuite email format. It should follow the pattern Ex. '12-12345@g.batstate-u.edu.ph'");
            UserUtil.clearFields(nameSignupTxt, gsuiteSignupTxt, passwordSignupTxt, departmentSignupTxt, roleSignupTxt, programSignupTxt);

            return;
        }

        if (!UserUtil.isValidPassword(password)) {
            AlarmManager.showErrorAlert("Password must be at least 8 characters long, contain at least one uppercase letter, and one number.");
            UserUtil.clearFields(nameSignupTxt, gsuiteSignupTxt, passwordSignupTxt, departmentSignupTxt, roleSignupTxt, programSignupTxt);
            return;
        }

        String srcode = UserUtil.extractSrcode(gsuite);
        User newUser = new User(srcode, fullname, gsuite, password, department, role, program);
        userService.addUser(newUser);
        AlarmManager.showSuccessAlert();

        UserUtil.clearFields(nameSignupTxt, gsuiteSignupTxt, passwordSignupTxt, departmentSignupTxt, roleSignupTxt, programSignupTxt);

    }

    @FXML
    public void userSignout(ActionEvent actionEvent) {
        SignoutHandler.handleExit();
    }

    @FXML
    public void goToLoginPage(ActionEvent actionEvent) {
        try {
            fxmlManager.loadPage(FXMLView.LOGIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
