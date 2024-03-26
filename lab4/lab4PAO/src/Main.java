import lab4.task1.JustMyFirstException;
import lab4.task2.CalculatorRequest;
import lab4.task2.CalculatorResult;
import lab4.task2.InvalidOperationException;
import lab4.task3.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lab4.task2.SmarterCalculator.calculate;

public class Main {

    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            try {

            } catch (RuntimeException e2){
                System.out.println("fail");
            }
        }
    }
    public static void foo() {
        try {
            System.out.println("1");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("2");
        }

        System.out.println("3");
    }
    public static void main(String[] args) {
        /*
        String[] inputs = {"1", "+", "2", "2", "*", "5", "1", "+", "0.5", "1.0", "-", "2.0", "10.0", "/", "0", "true", "&&", "false"};
        String[] inputs2 = {"true", "&&", "true"};
        List<CalculatorResult> results = calculate(inputs);

        for (CalculatorResult res: results){
            CalculatorRequest req = res.getRequest();
            Object leftOperand = req.getLeftOperand();
            Object rightOperand = req.getRightOperand();
            String operation = req.getRequestType();
            Object rasp = new Object();
            try {
                rasp = res.computeResult();
                System.out.println("Operation " + req + " has result " + rasp);
            } catch (InvalidOperationException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        */
        /*
        Map<String, Double> infoCurs = new HashMap<>();
        infoCurs.put("Mate", 6.7);
        infoCurs.put("Info", 9.9);

        Student student1 = new Student("Milan", infoCurs);
        System.out.println("OG Student: " + student1);

        Student student1Cloned = new Student();
        try {
            student1Cloned = (Student) student1.clone();
        } catch (CloneNotSupportedException e){
            System.err.println("Exception: " + e.getMessage());
        }

        System.out.println("Cloned Student: " + student1Cloned);
        student1Cloned.updateCourseInformation("Mate", 8.0);

        System.out.println("Original student after modification: " + student1);
        System.out.println("Cloned student after modification: " + student1Cloned);
        */


        /// task 4
        // foo();
        // bar();
    }
}
