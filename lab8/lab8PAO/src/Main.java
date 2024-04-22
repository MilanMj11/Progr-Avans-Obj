import lab8.task1.SmarterCalculatorSaver;
import smarterCalculator.CalculatorRequest;
import smarterCalculator.CalculatorResult;
import smarterCalculator.SmarterCalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/laborator";
        String username = "student";
        String password = "student";

        SmarterCalculatorSaver resultSaver = new SmarterCalculatorSaver(url, username, password);

        args = new String[]{"1", "+", "2", "2", "*", "5", "1", "+", "0.5", "1.0", "-", "2.0", "10.0", "/", "1", "true", "&&", "false"};

        List<CalculatorResult> results = SmarterCalculator.calculate(args);

        for (CalculatorResult res : results) {
            CalculatorRequest req = res.getRequest();
            Object rasp = res.computeResult();

            System.out.println("Operation " + req + " has result " + rasp);
            resultSaver.saveResult(req, res);
        }
    }
}