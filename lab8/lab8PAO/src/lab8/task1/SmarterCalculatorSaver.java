package lab8.task1;

import smarterCalculator.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SmarterCalculatorSaver {
    private final String url;
    private final String username;
    private final String password;

    public SmarterCalculatorSaver(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveResult(CalculatorRequest request, CalculatorResult result) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String operationType = request.getRequestType();

            String sql = "INSERT INTO smarterCalculatorResults(operation_type, left_operand, right_operand, operation, result) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, (String) operationType);
                statement.setString(2, (String) request.getLeftOperand());
                statement.setString(3, (String) request.getRightOperand());
                statement.setString(4, (String) request.getOperation());
                statement.setString(5, (String) result.computeResult());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save result", e);
        }
    }

}
