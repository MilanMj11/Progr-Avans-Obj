package lab5.bonus;

import java.util.HashSet;
import java.util.List;

public class TreeImpl<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private int size;

    public TreeImpl() {
        this.root = null;
        this.size = 0;
    }

    private void insertInTree(Node<T> node, T value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value));
                this.size++;
            } else {
                insertInTree(node.getLeft(), value);
            }
        } else if (value.compareTo(node.getValue()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<>(value));
                this.size++;
            } else {
                insertInTree(node.getRight(), value);
            }
        }
    }

    private HashSet<T> getValuesFromTree(Node<T> node, T inf, T sup) {
        HashSet<T> values = new HashSet<>();
        if (node == null) {
            return values;
        }
        if (node.getValue().compareTo(inf) > 0) {
            values.addAll(getValuesFromTree(node.getLeft(), inf, sup));
        }
        if (node.getValue().compareTo(inf) >= 0 && node.getValue().compareTo(sup) <= 0) {
            values.add(node.getValue());
        }
        if (node.getValue().compareTo(sup) < 0) {
            values.addAll(getValuesFromTree(node.getRight(), inf, sup));
        }
        return values;
    }

    @Override
    public void addValue(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
            size++;
        } else {
            insertInTree(this.root, value);
        }
    }

    @Override
    public void addAll(List<T> values) {
        for (T value : values) {
            addValue(value);
        }
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> values;
        values = getValuesFromTree(this.root, inf, sup);
        return values;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
