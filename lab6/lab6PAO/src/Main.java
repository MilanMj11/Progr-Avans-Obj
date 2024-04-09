import lab6.task1.*;
import lab6.task2.Topic;
import lab6.task2.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*

        /// task 1

        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Aurel Vlaicu", 5.3, 7.8, 9.0));
        studenti.add(new Student("Liviu Teodorescu", 7.7, 5.2, 9.0));
        studenti.add(new Student("Mujdar Milan", 9.2, 8.8, 9.0));
        studenti.add(new Student("Vasile Pop", 6.3, 10.0, 8.0));

        SortareDupaNotaTotala sortare1 = new SortareDupaNotaTotala();
        sortare1.afisareSortati(studenti);

        SortareDupaNotaPartial sortare2 = new SortareDupaNotaPartial();
        sortare2.afisareSortati(studenti);

        SortareDupaNotaMedie sortare3 = new SortareDupaNotaMedie();
        sortare3.afisareSortati(studenti);

         */

        /// task 2

        User adrian = new User("Adrian");
        User ion = new User("Ion");
        User maria = new User("Maria");
        User matei = new User("Matei");

        Topic gatit = new Topic("gatit");
        gatit.aboneaza(adrian);
        gatit.aboneaza(maria);

        Topic programare = new Topic("programare");
        programare.aboneaza(adrian);
        programare.aboneaza(ion);
        programare.aboneaza(maria);
        programare.aboneaza(matei);

        ion.trimiteMesaj("programare", "Salutare!");
        adrian.trimiteMesaj("gatit", "Omlette du fromage!");


    }
}