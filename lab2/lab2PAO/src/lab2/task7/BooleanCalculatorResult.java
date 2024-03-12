package lab2.task7;

public class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    @Override
    public Boolean computeResult(){
        boolean leftOperand = (boolean) super.getRequest().getLeftOperand();
        boolean rightOperand = (boolean) super.getRequest().getRightOperand();
        String operation = super.getRequest().getOperation();

        switch (operation){
            case "&&":
                return leftOperand && rightOperand;
            case "||":
                return leftOperand || rightOperand;
            default:
                return null;
        }
    }
}
