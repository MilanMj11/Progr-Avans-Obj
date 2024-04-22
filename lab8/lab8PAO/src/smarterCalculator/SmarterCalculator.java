package smarterCalculator;

import java.util.ArrayList;
import java.util.List;

public final class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args){
        List<CalculatorResult> results = new ArrayList<>();
        List<CalculatorRequest> requests = InputConverter.mapRequest(args);

        for (CalculatorRequest req : requests){
            String reqType = req.getRequestType();

            switch (reqType){
                case "Integer":
                    results.add(new IntegerCalculatorResult(req));
                    break;
                case "Double":
                    results.add(new DoubleCalculatorResult(req));
                    break;
                case "Boolean":
                    results.add(new BooleanCalculatorResult(req));
                    break;
                default:
                    System.out.println("Error Type not found!");
                    break;
            }
        }

        return results;
    }
}
