package ncnl.expensetracker;

import javafx.application.Application;
import javafx.stage.Stage;
import ncnl.expensetracker.views.FXMLManager;
import ncnl.expensetracker.views.FXMLView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLManager fxmlManager = new FXMLManager(primaryStage);
        fxmlManager.loadPage(FXMLView.LOGIN);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
