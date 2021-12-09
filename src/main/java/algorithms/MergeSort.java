package algorithms;

import org.junit.AfterClass;

import java.util.Collections;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

    @SuppressWarnings("unchecked")
    public void sort(List<T> array) {
        // First half
        if (array.size() > 1) {
            int mid = array.size() / 2;
            List<T> firstHalf = List.of((T[]) new Comparable[mid]);
            System.arraycopy(array, 0, firstHalf, 0, mid);

            // Second half
            List<T> secondHalf = List.of((T[]) new Comparable[array.size() - mid]);
            System.arraycopy(array, mid, secondHalf, 0, array.size() - mid);

            sort(firstHalf);
            sort(secondHalf);

            merge(firstHalf, secondHalf, array);
        }
    }



    public void sortWithSortingLib(List<T> array) {
        Collections.sort(array);
    }

    public void merge(List<T> firstHalf, List<T> secondHalf, List<T> array) {
        int currentIndexFirst = 0;
        int currentIndexSecond = 0;
        int currentIndexArray = 0;

        while(currentIndexFirst < firstHalf.size() && currentIndexSecond < secondHalf.size()) {
            if(firstHalf.get(currentIndexFirst).compareTo(secondHalf.get(currentIndexSecond)) < 0) {
                array.set(currentIndexArray, (T) firstHalf.get(currentIndexFirst));
                currentIndexArray++;
                currentIndexFirst++;
            } else {
                array.set(currentIndexArray, (T) secondHalf.get(currentIndexSecond));
                currentIndexArray++;
                currentIndexSecond++;
            }
        }
        while(currentIndexFirst < firstHalf.size()) {
            array.set(currentIndexArray, firstHalf.get(currentIndexFirst));
            currentIndexArray++;
            currentIndexFirst++;
        }
        while(currentIndexSecond < secondHalf.size()) {
            array.set(currentIndexArray, secondHalf.get(currentIndexSecond));
            currentIndexArray++;
            currentIndexSecond++;
        }
    }
}
