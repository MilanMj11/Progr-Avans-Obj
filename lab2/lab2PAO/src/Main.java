import lab2.task6.*;
import lab2.task7.CalculatorRequest;
import lab2.task7.CalculatorResult;
import lab2.task7.SmarterCalculator;

import java.util.List;

import static lab2.task7.SmarterCalculator.calculate;


public class Main {
    public static void main(String[] args) {
        /*
        Patrulater patrat = new Patrat(10);
        Patrulater dreptunghi = new Dreptunghi(10,20);
        Patrulater paralelogram = new Paralelogram(20,10,60,120);
        Patrulater romb = new Romb(5,10,60,120,8,10);
        System.out.println(patrat.arie());
        System.out.println(dreptunghi.arie());
        System.out.println(romb.arie());
        System.out.println(paralelogram.arie());
         */

        String[] inputs = {"1", "+", "2", "2", "*", "5", "1", "+", "0.5", "1.0", "-", "2.0", "10.0", "/", "1", "true", "&&", "false"};
        String[] inputs2 = {"true", "&&", "true"};
        List<CalculatorResult> results = calculate(inputs);

        for (CalculatorResult res: results){
            CalculatorRequest req = res.getRequest();
            Object leftOperand = req.getLeftOperand();
            Object rightOperand = req.getRightOperand();
            String operation = req.getRequestType();
            Object rasp = res.computeResult();

            System.out.println("Operation " + req + " has result " + rasp);
        }
    }
}