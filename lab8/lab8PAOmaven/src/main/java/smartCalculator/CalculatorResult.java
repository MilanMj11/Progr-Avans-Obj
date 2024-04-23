package smartCalculator;

public class CalculatorResult {
    private final CalculatorRequest calculatorRequest;

    public CalculatorResult(CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public Object computeResult(){
        return null;
    }

    @Override
    public String toString(){
        return getRequest().toString() + " = " + computeResult();
    }
}
