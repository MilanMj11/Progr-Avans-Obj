package task2;

import smartCalculator.CalculatorRequest;
import smartCalculator.CalculatorResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SmartCalculatorReader {
    private final String url;
    private final String username;
    private final String password;

    public SmartCalculatorReader(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<CalculatorResult> readResults() {

        List<CalculatorResult> results = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);

            String sql = "SELECT operation_type, left_operand, right_operand, operation, result FROM smarterCalculatorResults";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String operationType = resultSet.getString("operation_type");
                double leftOperand = resultSet.getDouble("left_operand");
                double rightOperand = resultSet.getDouble("right_operand");
                char operation = resultSet.getString("operation").charAt(0);

                CalculatorRequest req = new CalculatorRequest(leftOperand, rightOperand, String.valueOf(operation));
                CalculatorResult res = new CalculatorResult(req);

                results.add(res);
                // System.out.println(res);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Eroare la citire", e);
        }

        return results;
    }
}
