package lab3.task6;

public class CalculatorResult {
    private final CalculatorRequest calculatorRequest;

    protected CalculatorResult(CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public Object computeResult(){
        return null;
    }
}
