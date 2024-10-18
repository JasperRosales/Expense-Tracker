package ncnl.expensetracker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.awt.*;


public class MainDashboardController extends GenericController {

    @FXML
    private Hyperlink linkToHomePanel, linkToManagePanel, linkToReportPanel, linkToCICSPanel, linkToCETPanel, linkToSettingPanel, linkToEventPanel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button exitBtn;


    @FXML
    public void changeOnHoverEnter(MouseEvent event) {
        Hyperlink link = (Hyperlink) event.getSource();
        link.setStyle("-fx-background-color: #F95454; -fx-text-fill: white; fx-border-color : transparent");
    }

    @FXML
        public void changeOnHoverExit(MouseEvent event) {
        Hyperlink link = (Hyperlink) event.getSource();
        link.setStyle("-fx-background-color: transparent; -fx-text-fill: #ebebeb; fx-border-color : transparent;");
    }


    public void userExit(ActionEvent actionEvent) {
    }
}
