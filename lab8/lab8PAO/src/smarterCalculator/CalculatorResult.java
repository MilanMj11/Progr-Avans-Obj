package smarterCalculator;

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

    @Override
    public String toString(){
        return getRequest().toString() + " = " + computeResult();
    }
}
