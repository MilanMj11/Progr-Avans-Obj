import lab9.task1.SortedListSet;
import lab9.task2.MyWordCounter;
import lab9.task2.WordCounter;

public class Main {
    public static void main(String[] args) {
        /// task 1

        /*
        SortedListSet<Integer> set = new SortedListSet<>();

        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(17);
        set.add(2);

        SortedListSet<Integer> subset = (SortedListSet<Integer>) set.subSet(5, 20);
        SortedListSet<Integer> subset2 = (SortedListSet<Integer>) set.tailSet(3);
        System.out.println(subset);
        System.out.println(subset2);

        */

        /// task 2

        WordCounter counter = new MyWordCounter();
        counter.parse("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        counter.printWordCounts();

    }
}