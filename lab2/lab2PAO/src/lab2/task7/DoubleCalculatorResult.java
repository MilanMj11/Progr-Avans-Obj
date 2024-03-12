package lab2.task7;

public class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Double computeResult(){
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
                    return null;
                return leftOperand / rightOperand;
            default:
                return null;
        }
    }
}
