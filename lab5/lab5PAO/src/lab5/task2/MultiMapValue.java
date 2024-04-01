package lab5.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMapValue<K, V> {
    private HashMap<K, ArrayList<V>> map;

    public MultiMapValue() {
        this.map = new HashMap<>();
    }

    public void add(K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    public void addAll(K key, List<V> values) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).addAll(values);
    }

    public void addAll(MultiMapValue<K, V> addMap) {
        for (K key : addMap.map.keySet()) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).addAll(addMap.map.get(key));
        }
    }

    public V getFirst(K key) {
        List<V> values = map.get(key);
        if (values != null && !values.isEmpty()) {
            return values.get(0);
        }
        return null;
    }

    public List<V> getValues(K key) {
        return map.getOrDefault(key, new ArrayList<>());
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public List<V> remove(K key) {
        return map.remove(key);
    }

    public int size() {
        int size = 0;
        for (List<V> listValues : map.values()) {
            size += listValues.size();
        }
        return size;
    }

}
