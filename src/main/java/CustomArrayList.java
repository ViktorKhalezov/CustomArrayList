import java.util.Comparator;


public class CustomArrayList<T> {

    private T[] array;

    private int capacity;

    private int size;

    /** Constructor that creates list with default initial capacity */
    public CustomArrayList() {
        capacity = 10;
        array = (T[]) new Object[capacity];
    }

    /** Constructor that creates list with specified capacity */
    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    /** Adds element at the end of list */
    public void add(T element) {
        if(size == capacity) {
            increaseCapacity();
        }
        array[size] = element;
        size++;
    }

    /** Adds element at specified position */
    public void add(int index, T element) {
        if(index <= size && index >= 0) {
            if (size == capacity) {
                increaseCapacity();
            }
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        }
    }

    /** Returns element by specified index */
    public T get(int index) {
        if(index < size && index >= 0) {
            return array[index];
        }
        return null;
    }

    /** Returns first occurrence of specified element. Returns -1 if list doesn't contain specified element */
    public int indexOf(Object element) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /** Removes element by specified index */
    public T remove(int index) {
        T removingElement = null;
        if(index < size && index >= 0) {
            removingElement = array[index];
                size--;
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        return removingElement;
    }

    /** Removes first occurrence of specified element */
    public boolean remove(Object element) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                size--;
                System.arraycopy(array, i + 1, array, i, size - i);
                return true;
            }
        }
        return false;
    }

    /** Removes all elements from the list */
    public void clear() {
        if(size > 0) {
            for(int i = 0; i < size; i++) {
                array[i] = null;
            }
        }
        size = 0;
    }

    /** Sorts the list */
    public void sort(Comparator<? super T> comparator) {
        int low = 0;
        int high = size - 1;
        quickSort(array, low, high, comparator);
    }

    /** Replaces element in specified position */
    public void set(int index, T element) {
        if(index < size && index >= 0) {
            array[index] = element;
        }
    }

    /** Returns size of the list */
    public int size() {
        return size;
    }


    /** Increases the capacity of the array */
    private void increaseCapacity() {
        double extendedCapacity = capacity * 1.5;
        capacity = (int) extendedCapacity;
        T[] extendedArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, extendedArray, 0, array.length);
        array = extendedArray;
    }

    /** Returns the array as string */
    public String toString() {
        if(size > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for(int i = 0; i < size - 1; i++) {
                stringBuilder.append(array[i]).append(", ");
            }
            return stringBuilder.append(array[size - 1]).append("]").toString();
        } else {
            return "";
        }
    }

    /** Sorts array by quicksort algorithm */
    private void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (array.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        T pivot = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(array[i], pivot) < 0) {
                i++;
            }

            while (comparator.compare(array[j], pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j, comparator);
        }

        if (high > i) {
            quickSort(array, i, high, comparator);
        }
    }

}
