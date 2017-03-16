import java.util.AbstractList;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heap<T extends Comparable<T>> extends PriorityQueue<T>{
    private int maxElements;
    private int currentSize;

    private AbstractList<T> array;

    public static <E extends Comparable<E>> E[] heapSort(E[] array){
        Heap<E> heap = new Heap<>(array.length + 1);
        for (E anArray : array) heap.put(anArray);

        for (int i = 0; i < array.length; i++)
            array[i] = heap.getMax();

        return array;
    }

    public Heap(int size){
        maxElements = size;
        array = new ArrayList<T>(size);
    }

    @SuppressWarnings("unchecked")
    public T[] removeAllToSortedArray(){
        T[] ret = (T[]) new Comparable[currentSize];
        for (int i = 0; i < ret.length; i++){
            ret[i] = getMax();
        }
        return ret;
    }

    public void put(T value){
        if (currentSize == maxElements && array.get(maxElements - 1).compareTo(value) < 0){
            array.add(maxElements - 1, value);
        } else {
            array.add(currentSize, value);
            currentSize++;
        }
        goUp(currentSize - 1);
    }

    public T getMax(){
        if (currentSize == 0) return null;

        T removed = array.get(0);
        currentSize--;

        array.set(0, array.get(currentSize));
        array.remove(currentSize);
        goDown(0);
        return removed;
    }

    private void goUp(int index){
        boolean next = true;
        while (index != 0 && next){
            int indexParent = index/2;
            int index1 = indexParent * 2;
            int index2 = indexParent * 2 + 1;
            trySwap(index1, index2);
            next = trySwap(indexParent, index1);
            index = indexParent;
        }
    }

    private void goDown(int index){
        boolean next = true;
        while (next){
            int index1 = index * 2;
            int index2 = index * 2 + 1;

            int maxIndex = index1;
            try {
                maxIndex = array.get(index1).compareTo(array.get(index2)) < 0 ? index2 : index1;
            } catch (Exception ignored) { }

            next = trySwap(index, maxIndex);
            index = maxIndex;
        }
    }

    private boolean trySwap(int index1, int index2){
        try {
            T val1 = array.get(index1);
            T val2 = array.get(index2);
            if (val1.compareTo(val2) < 0){
                array.set(index1, val2);
                array.set(index2, val1);
                return true;
            }
            return false;
        }catch (Exception ignored) { }
        return false;
    }
}
