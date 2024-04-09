package lab6.task1;

import java.util.Collections;
import java.util.List;

public class SortareDupaNotaPartial implements SortareStudenti{
    public void sortare(List<Student> studenti) {
        Collections.sort(studenti, (x, y) -> Double.compare(y.getNotaPartial(), x.getNotaPartial()));
    }

    public void afisareSortati(List<Student> studenti) {
        System.out.println("Sortare dupa cea mai mare nota partiala");
        sortare(studenti);
        int i = 1;
        for (Student student : studenti) {
            System.out.println(i + ". " + student);
            i++;
        }
    }
}
