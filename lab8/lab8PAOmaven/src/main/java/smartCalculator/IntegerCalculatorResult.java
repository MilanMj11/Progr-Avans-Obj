package smartCalculator;

public final class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Integer computeResult(){
        int leftOperand = (int) super.getRequest().getLeftOperand();
        int rightOperand = (int) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        switch (operation){
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                if (rightOperand == 0)
                    return null;
                return leftOperand / rightOperand;
            default:
                return null;
        }
    }
}
