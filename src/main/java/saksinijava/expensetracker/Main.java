package saksinijava.expensetracker;

import javafx.application.Application;
import javafx.stage.Stage;
import saksinijava.expensetracker.views.FXMLviewer;

import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLviewer.loadView(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}