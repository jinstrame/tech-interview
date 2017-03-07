import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ChainMap<K, V> implements MyMap<K, V> {

    private int capacity;
    private ArrayList<List<KeyValuePair<K, V>>> array;

    public ChainMap(int capacity){
        this.capacity = capacity;
        array = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++){
            array.add(new LinkedList<>());
        }
    }

    @Override
    public V get(K key) {
        List<KeyValuePair<K, V>> list = array.get(key.hashCode() % capacity);
        for (KeyValuePair<K, V> kvp : list){
            if (kvp.getKey().equals(key))
                return kvp.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V alreadyIn = this.get(key);
        List<KeyValuePair<K, V>> list = array.get(key.hashCode() % capacity);
        if (alreadyIn != null){
            for (KeyValuePair<K, V> kvp : list){
                if (kvp.getKey().equals(key)){
                    kvp.setValue(value);
                    return value;
                }
            }
        }
        else {
            list.add(new KeyValuePair<>(key, value));
            return value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        List<KeyValuePair<K, V>> list = array.get(key.hashCode() % capacity);
        ListIterator<KeyValuePair<K, V>> iterator = list.listIterator();
        while (iterator.hasNext()){
            KeyValuePair<K, V> kvp = iterator.next();
            if (kvp.getKey().equals(key)){
                iterator.remove();
                return kvp.getValue();
            }
        }
        return null;
    }
}
