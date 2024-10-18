package ncnl.expensetracker.views;

public enum FXMLView {
    LOGIN("/fxml/LoginPage.fxml"),
    SIGNUP("/fxml/SignupPage.fxml"),
    MAINDASHBOARD("/fxml/MainDashboard.fxml");

    private final String path;

    FXMLView(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
