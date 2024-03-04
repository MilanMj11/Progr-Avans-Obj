package lab1.task4;

import java.security.cert.TrustAnchor;
import java.util.Stack;

public class DummyCalculator {
    public static void calculate(String[] args){
        if(args.length != 3){
            System.out.println("Invalid number of arguments!");
            return;
        }

        if(args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")){
            boolean st = Boolean.parseBoolean(args[0]);
            boolean dr = Boolean.parseBoolean(args[2]);
            char operatie = args[1].charAt(0);

            boolean rasp = operatieLogica(st,dr,operatie);
            System.out.println("Raspuns: " + rasp);
        } else {
            double st = Double.parseDouble(args[0]);
            double dr = Double.parseDouble(args[2]);
            char operatie = args[1].charAt(0);

            double rasp = operatieAritmetica(st,dr,operatie);
            System.out.println("Raspuns: " + rasp);
        }

    }

    public static double operatieAritmetica(double nr1, double nr2, char operatie){
        switch (operatie){
            case '+':
                return nr1 + nr2;
            case '-':
                return nr1 - nr2;
            case '*':
                return nr1 * nr2;
            case '/':
                if(nr2 == 0){
                    System.out.println("Eroare: Nu poti imparti la 0");
                    return Double.NaN;
                }
                return nr1 / nr2;
            default:
                System.out.println("Eroare: Operatie invalida!");
                return Double.NaN;
        }
    }

    public static boolean operatieLogica(boolean nr1, boolean nr2, char operatie){
        switch (operatie){
            case '&':
                return nr1 && nr2;
            case '|':
                return nr1 || nr2;
            default:
                System.out.println("Eroare: Operatie invalida!");
                return false;
        }
    }

}
