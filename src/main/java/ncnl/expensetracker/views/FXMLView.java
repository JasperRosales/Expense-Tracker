package ncnl.expensetracker.views;

public enum FXMLView {
    LOGIN("/fxml/LoginPage.fxml"),
    SIGNUP("/fxml/SignupPage.fxml"),
    MAINDASHBOARD("/fxml/MainDashboard.fxml"),
    CET("/fxml/CETPage.fxml"),
    CICS("/fxml/CICSPage.fxml"),
    EVENT("/fxml/EventPage.fxml"),
    HOME("/fxml/HomePage.fxml"),
    MANAGEMENT("/fxml/ManagementPage.fxml"),
    REPORT("/fxml/ReportPage.fxml"),
    SETTING("/fxml/SettingPage.fxml"),
    ADMIN("/fxml/AdminDashboard.fxml");

    private final String path;

    FXMLView(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return path;
    }
}
