package ncnl.expensetracker.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ncnl.expensetracker.controller.GenericController;

public class FXMLManager {
    private Stage primaryStage;

    public FXMLManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void loadPage(FXMLView view) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view.getPath()));
        Parent root = loader.load();

        GenericController controller = loader.getController();
        if (controller != null) {
            controller.setFxmlManager(this);
        }
        primaryStage.setScene(new Scene(root));

        if (view == FXMLView.MAINDASHBOARD) {
            primaryStage.setWidth(1200);
            primaryStage.setHeight(800);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
        } else {
            primaryStage.setResizable(true);
        }
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
