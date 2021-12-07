package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

    @SuppressWarnings("unchecked")
    public void sort(List<T> array) {
        // Obtain the first half
        if (array.size() > 1) {
            int mid = array.size() / 2;
            List<T> firstHalf = List.of((T[]) new Comparable[mid]);
            System.arraycopy(array, 0, firstHalf, 0, mid);

            // Obtain the second half
            List<T> secondHalf = List.of((T[]) new Comparable[array.size() - mid]);
            System.arraycopy(array, mid, secondHalf, 0, array.size() - mid);

            // Recursively sort the two halves
            sort(firstHalf);
            sort(secondHalf);

            //Merge firstHalf

            merge(firstHalf, secondHalf, array);
        }
    }



    public <T extends Comparable<T>> void sortWithSortingLib(List<T> array) {
        Collections.sort(array);
    }

    public <T extends Comparable<T>> void merge(List<T> firstHalf, List<T> secondHalf, List<T> array) {
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
