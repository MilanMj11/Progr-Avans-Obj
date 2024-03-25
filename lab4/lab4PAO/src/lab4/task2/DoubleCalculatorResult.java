package lab4.task2;

public final class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Double computeResult() throws InvalidOperationException{
        double leftOperand;
        double rightOperand;
        if (super.getRequest().getLeftOperand() instanceof Integer)
            leftOperand = (double) (int) super.getRequest().getLeftOperand();
        else
            leftOperand = (double) super.getRequest().getLeftOperand();

        if (super.getRequest().getRightOperand() instanceof Integer)
            rightOperand = (double) (int) super.getRequest().getRightOperand();
        else
            rightOperand = (double) super.getRequest().getRightOperand();
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
