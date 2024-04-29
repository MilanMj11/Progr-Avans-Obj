package lab9.task1;

import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedSet;

public class SortedListSet<T extends Comparable<T>> extends LinkedList<T> implements SortedSet<T> {

    private Comparator<T> comparator;

    public SortedListSet() {
        this.comparator = null;
    }

    public SortedListSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator<T> comparator() {
        return comparator;
    }

    /// -> daca nu am functia de "comparator()" atunci e eroare;
    public Comparator<T> getComparator() {
        return comparator;
    }

    public boolean add(T o) {
        if (o == null) {
            throw new NullPointerException("Cannot add null!");
        }
        int index = 0;
        if (comparator != null) {
            while (index < size() && comparator.compare(get(index), o) < 0) {
                index++;
            }
        } else {
            while (index < size() && get(index).compareTo(o) < 0) {
                index++;
            }
        }
        if (index == size() || !(get(index).equals(o))) {
            add(index, o);
            return true;
        }
        return false;
    }

    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return get(0);
    }

    public T last() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return get(size() - 1);
    }

    private boolean compare(T elem, T elem2, Comparator<T> comparator) {
        if (comparator != null) {
            return comparator.compare(elem, elem2) >= 0;
        }
        return elem.compareTo(elem2) >= 0;
    }

    public SortedSet<T> subSet(T from, T to) {
        SortedListSet<T> subset = new SortedListSet<>(comparator);
        for (T elem : this) {
            boolean added = false;
            if (compare(elem, from, comparator) && !compare(elem, to, comparator)) {
                subset.add(elem);
                added = true;
            }
        }
        return subset;
    }

    public SortedSet<T> headSet(T to) {
        SortedListSet<T> headset = new SortedListSet<>(comparator);
        for (T elem : this) {
            boolean added = false;
            if (!compare(elem, to, comparator)) {
                headset.add(elem);
                added = true;
            }
        }
        return headset;
    }

    public SortedSet<T> tailSet(T from) {
        SortedListSet<T> tailset = new SortedListSet<>(comparator);
        for (T elem : this) {
            if (compare(elem, from, comparator)) {
                tailset.add(elem);
            }
        }
        return tailset;
    }
}
