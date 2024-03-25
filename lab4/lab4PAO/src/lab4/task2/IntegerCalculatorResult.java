package lab4.task2;

public final class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Integer computeResult() throws InvalidOperationException{
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
                    throw new InvalidOperationException("Can't divide by 0!");
                return leftOperand / rightOperand;
            default:
                throw new InvalidOperationException("Unknown operation: " + operation);
        }
    }
}
