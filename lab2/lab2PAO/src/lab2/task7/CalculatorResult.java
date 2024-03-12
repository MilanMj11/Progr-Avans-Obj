package lab2.task7;

public abstract class CalculatorResult {
    private final CalculatorRequest calculatorRequest;

    protected CalculatorResult(CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public abstract Object computeResult();
}
