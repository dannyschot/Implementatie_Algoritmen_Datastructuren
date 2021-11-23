package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithm<T extends Comparable<T>> {
    public <T> void sortWithSortingLib(ArrayList array) {
        Collections.sort(array);
    }

    public void insertionSort(List<T> data) {
        int i, x;
        T currentNumber;
        try {
            for (i = 1; i < data.size(); i++){
                currentNumber = data.get(i);
                x = i - 1;
                while (x >= 0 && data.get(x).compareTo(currentNumber) > 0){
                    data.set(x + 1, data.get(x));
                    x--;
                }
                data.set(x + 1, currentNumber);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
