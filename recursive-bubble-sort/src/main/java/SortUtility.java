import java.util.Comparator;

@SuppressWarnings("WeakerAccess")
public class SortUtility {
    public static <T> void recursiveBubble(T[] elements, Comparator<T> comparator){
        recursiveMethod(elements, elements.length - 1, comparator);
    }

    private static <T> void recursiveMethod(T[] elements, int current_size, Comparator<T> comparator){
        if (current_size == 0) {
            return;
        }

        oneLineSwap(elements, current_size, comparator);
        recursiveMethod(elements, current_size - 1, comparator);
    }

    private static <T> void oneLineSwap(T[] elements, int limit, Comparator<T> comparator){
        for (int i = 0; i < limit; i++){
            if (comparator.compare(elements[i], elements[limit]) > 0){
                swap(elements, i, limit);
            }
        }
    }

    private static <T> void swap(T[] elements, int i1, int i2){
        T t = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = t;
    }

}
