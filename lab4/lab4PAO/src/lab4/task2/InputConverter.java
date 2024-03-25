package lab4.task2;

import java.util.ArrayList;
import java.util.List;

public final class InputConverter {
    public static List<CalculatorRequest> mapRequest(String[] args) throws UnknownOperandTypeException{
        List<CalculatorRequest> requests = new ArrayList<>();

        for(int i=0;i<args.length;i+=3){
            if(i+2 < args.length) {
                try {
                    Object leftOperand = parseOperand(args[i]);
                    Object rightOperand = parseOperand(args[i+2]);
                    String operation = args[i+1];

                    CalculatorRequest req = new CalculatorRequest(leftOperand,rightOperand,operation);
                    requests.add(req);
                } catch (UnknownOperandTypeException e){
                    System.err.println("Exception: " + e.getMessage());
                }

            }
        }

        return requests;
    }

    private static Object parseOperand(String operand) throws UnknownOperandTypeException{
        try{
            if(operand.contains(".")){
                /// double
                return Double.parseDouble(operand);
            } else if (operand.equalsIgnoreCase("true") || operand.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(operand);
            } else {
                /// int
                return Integer.parseInt(operand);
            }
        } catch (NumberFormatException e){
            throw new UnknownOperandTypeException(operand);
        }
    }
}
