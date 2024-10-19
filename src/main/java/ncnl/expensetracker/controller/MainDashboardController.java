package ncnl.expensetracker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import ncnl.expensetracker.views.FXMLView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardController extends GenericController implements Initializable {

    @FXML
    private Hyperlink linkToHomePanel, linkToManagePanel, linkToReportPanel, linkToCICSPanel, linkToCETPanel, linkToSettingPanel, linkToEventPanel;

    @FXML
    private StackPane contentArea;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button exitBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage(FXMLView.HOME);
    }

    @FXML
    public void changeOnHoverEnter(MouseEvent event) {
        Hyperlink link = (Hyperlink) event.getSource();
        link.setStyle("-fx-background-color: #F95454; -fx-text-fill: white; -fx-border-color: transparent;");
    }

    @FXML
    public void changeOnHoverExit(MouseEvent event) {
        Hyperlink link = (Hyperlink) event.getSource();
        link.setStyle("-fx-background-color: transparent; -fx-text-fill: #ebebeb; -fx-border-color: transparent;");
    }

    @FXML
    public void HyperlinkClick(ActionEvent event) {
        Hyperlink source = (Hyperlink) event.getSource();
        FXMLView view = null;

        if (source == linkToHomePanel) {
            view = FXMLView.HOME;
        } else if (source == linkToManagePanel) {
            view = FXMLView.MANAGEMENT;
        } else if (source == linkToReportPanel) {
            view = FXMLView.REPORT;
        } else if (source == linkToCICSPanel) {
            view = FXMLView.CICS;
        } else if (source == linkToCETPanel) {
            view = FXMLView.CET;
        } else if (source == linkToSettingPanel) {
            view = FXMLView.SETTING;
        } else if (source == linkToEventPanel) {
            view = FXMLView.EVENT;
        }

        if (view != null) {
            loadPage(view);
        }
    }

    private void loadPage(FXMLView view) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(view.toString()));
            Parent page = loader.load();
            contentArea.getChildren().clear();
            contentArea.getChildren().add(page);
            contentArea.isCenterShape();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
