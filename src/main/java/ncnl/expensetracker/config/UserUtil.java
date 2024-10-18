package ncnl.expensetracker.config;

import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;


public class UserUtil {

    private static final String GSUITE_PATTERN = "\\d{2}-\\d{5}@g\\.batstate-u\\.edu\\.ph";


    public static boolean isValidGsuiteEmail(String email) {
        return email.matches(GSUITE_PATTERN);
    }

    public static String extractSrcode(String gsuite) {
        if (gsuite != null && gsuite.contains("@")) {
            return gsuite.substring(0, gsuite.indexOf('@'));
        }
        return "";
    }
    public static void clearFields(Node... fields) {
        for (Node field : fields) {
            if (field instanceof TextField) {
                ((TextField) field).clear();
            } else if (field instanceof PasswordField) {
                ((PasswordField) field).clear();
            }
        }
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false; // Minimum length check
        }
        boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        return hasUpperCase && hasDigit; // Check for uppercase and digit
    }
}
