package ncnl.expensetracker.service;

import ncnl.expensetracker.config.DatabaseConfig;
import ncnl.expensetracker.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {

    // Method to add a new user with a hashed password
    public void addUser(User user) {
        String query = "INSERT INTO user (srcode, fullname, gsuite, password, department, role, program) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getUserConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Hash the password before storing it
            stmt.setString(1, user.getSrcode());
            stmt.setString(2, user.getFullname());
            stmt.setString(3, user.getGsuite());
            stmt.setString(4, hashPassword(user.getPassword()));
            stmt.setString(5, user.getDepartment());
            stmt.setString(6, user.getRole());
            stmt.setString(7, user.getProgram());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public User authenticateUser(String srcode, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE srcode = ?";

        try (Connection connection = DatabaseConfig.getUserConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the srcode in the query
            statement.setString(1, srcode);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedHashedPassword = resultSet.getString("password");

                if (storedHashedPassword.equals(hashPassword(password))) {
                    user = new User(
                            resultSet.getString("srcode"),
                            resultSet.getString("fullname"),
                            resultSet.getString("gsuite"),
                            resultSet.getString("password"),
                            resultSet.getString("department"),
                            resultSet.getString("role"),
                            resultSet.getString("program")
                    );
                } else {
                    System.out.println("Invalid password.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error authenticating user: " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    // Method to hash passwords using SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
