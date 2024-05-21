package lab11.task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamSquares {

    private static List<Integer> generateNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(500));  // Am generat numere pana in 500 pentru a nu avea numere prea mari
        }
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        int[] sizes = {10, 1000, 10000, 10000000};

        BufferedWriter writer = new BufferedWriter(new FileWriter("timing_results.txt", true));

        for (int size : sizes) {
            List<Integer> numbers = generateNumbers(size);

            long startTime = System.nanoTime();

            numbers.parallelStream()
                    .forEach(number -> System.out.printf("%d^2=%d%n", number, number * number));

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            writer.write(String.format("ParallelStream, Size %d: %d ns%n", size, duration));
            writer.flush();
        }

        writer.close();

    }

}
