package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> { // TODO:: Kijken of constructor weg kan worden gelaten
    private final int nElements;
    private final List<T> unsortedList;

    public SelectionSort(List<T> data) {
        unsortedList = data;
        nElements = data.size();
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }


    public void sort() {
        int out, in, min;

        try {
            for (out = 0; out < nElements; out++) {
                min = out;
                for (in = out + 1; in < nElements; in++) {
                    if (unsortedList.get(in).compareTo(unsortedList.get(min)) < 0) {
                        min = in;
                    }
                }
                swap(out, min);
            }
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    private void swap(int one, int two) {
        T temp = unsortedList.get(one);
        unsortedList.set(one, unsortedList.get(two));
        unsortedList.set(two, temp);
    }

    public void display() {
        for(T element : unsortedList) {
            System.out.println(element);
        }
    }
}
