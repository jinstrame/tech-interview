@SuppressWarnings("WeakerAccess")
public class SortUtility {
    public static <T extends Comparable> void recursiveBubble(T[] elements) {
        recursiveMethod(elements, elements.length - 1);
    }

    private static <T extends Comparable> void recursiveMethod(T[] elements, int current_size) {
        if (current_size <= 0) {
            return;
        }

        oneLineSwap(elements, current_size);
        recursiveMethod(elements, current_size - 1);
    }

    private static <T extends Comparable> void oneLineSwap(T[] elements, int limit) {
        for (int i = 0; i < limit; i++) {
            //noinspection unchecked
            if (elements[i].compareTo(elements[limit]) > 0) {
                swap(elements, i, limit);
            }
        }
    }

    private static <T extends Comparable> void swap(T[] elements, int i1, int i2) {
        T t = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = t;
    }

}