package devproblem_api;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ValueComparator<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<K> {

    private final Map<K, V> map = new HashMap<>();

    public ValueComparator(Map<K, V> kvMap) {
        this.map.putAll(kvMap);
    }

    @Override
    public int compare(K k1, K k2) {
        //in case the result is turns our to be zero, it easts up an element
        int result = map.get(k2).compareTo(map.get(k1));
        return  result != 0 ? result: k1.compareTo(k2);
    }
}
