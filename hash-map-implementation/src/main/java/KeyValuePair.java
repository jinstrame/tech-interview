import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyValuePair<K, V> {
    private K key;
    private V value;
}
