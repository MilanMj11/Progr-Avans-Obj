package lab2.task7;

import lab2.task6.Patrulater;

import javax.management.openmbean.OpenMBeanConstructorInfo;
import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public static List<CalculatorRequest> mapRequest(String[] args){
        List<CalculatorRequest> requests = new ArrayList<>();

        for(int i=0;i<args.length;i+=3){
            if(i+2 < args.length) {
                Object leftOperand = parseOperand(args[i]);
                Object rightOperand = parseOperand(args[i+2]);
                String operation = args[i+1];

                CalculatorRequest req = new CalculatorRequest(leftOperand,rightOperand,operation);
                requests.add(req);
            }
        }

        return requests;
    }

    private static Object parseOperand(String operand){
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
            return operand;
        }
    }
}
