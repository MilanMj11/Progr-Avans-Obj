package smarterCalculator;

public final class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        boolean leftOperand = (boolean) getRequest().getLeftOperand();
        boolean rightOperand = (boolean) getRequest().getRightOperand();
        String operation = getRequest().getOperation();

        switch (operation) {
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                return null;
        }
    }
}
