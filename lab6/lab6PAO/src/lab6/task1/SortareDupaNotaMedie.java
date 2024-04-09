package lab6.task1;

import java.util.Collections;
import java.util.List;

public class SortareDupaNotaMedie implements SortareStudenti{
    public void sortare(List<Student> studenti) {
        Collections.sort(studenti, (x, y) -> Double.compare(y.getNotaMedie(), x.getNotaMedie()));
    }

    public void afisareSortati(List<Student> studenti) {
        System.out.println("Sortare dupa cea mai mare nota medie");
        sortare(studenti);
        int i = 1;
        for (Student student : studenti) {
            System.out.println(i + ". " + student);
            i++;
        }
    }
}
