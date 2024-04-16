import lab7.task4.PairObj;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // task 1
        // metoda 1
        /*
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Mujdar Milan\\Desktop\\labPAO\\lab7\\lab7PAO\\src\\lab7\\task1\\input.txt");
            file.skip(20);
            while(file.available() > 0){
                System.out.print((char)file.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // metoda 2
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Mujdar Milan\\Desktop\\labPAO\\lab7\\lab7PAO\\src\\lab7\\task1\\input.txt");
            char ch = ' ';
            while(file.available() > 0 && ch != '\n'){
                ch = (char)file.read();
            }
            while(file.available() > 0){
                System.out.print((char)file.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

        // task 2
        /*
        try {
            FileReader file = new FileReader("C:\\Users\\Mujdar Milan\\Desktop\\labPAO\\lab7\\lab7PAO\\src\\lab7\\task1\\input.txt");

            while((char)file.read() != '\n');

            int ch;
            while ((ch = file.read()) != -1) {
                System.out.print((char) ch);
            }

            file.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        */

        // task 3
        /*
        for (int i = 1; i <= 10; i++) {
            try {
                FileWriter file = new FileWriter("C:\\Users\\Mujdar Milan\\Desktop\\labPAO\\lab7\\lab7PAO\\src\\lab7\\task3\\fisier" + i + ".txt");
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                file.write("Index: " + i + "\n");
                file.write("Ora: " + time.format(formatter) + "\n");

                file.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        */

        // task 4
        /*
        int n = 15;
        IntStream.rangeClosed(2,n)
                .filter(x -> x % 2 == 0)
                .mapToObj(x -> new PairObj(x, x*x))
                .forEach(System.out::println);
        */

        // task 5
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Womp womp!");
        }

        List<Integer> lista = new ArrayList<>();
        int ind = 0;
        while (ind < n) {
            int nr = 0;

            boolean ok = true;

            try {
                nr = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Womp womp 2 !");
                ok = false;
            }

            if (ok == true)
                lista.add(nr);
            ind++;
        }

        List<DoubleUnaryOperator> operatii = Arrays.asList(
                nr -> nr * 2,
                nr -> nr + 1,
                nr -> 1 / nr,
                nr -> nr * nr,
                nr -> Math.round(Math.sin(Math.toRadians(nr)) * 100.0) / 100.0
        );

        lista.forEach(nr -> {
            Random random_nr = new Random();

            DoubleUnaryOperator operatie = operatii.get(random_nr.nextInt(operatii.size()));

            double rasp = operatie.applyAsDouble(nr);
            System.out.println("Rezultat: " + rasp);
        });


    }
}