package algorithms;

import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingAlgorithm {
    public <T> ArrayList sortWithSortingLib(ArrayList array) {
        Collections.sort(array);
        return array;
    }

    public <T extends Comparable<T>> List<T> insertionSort(List<T> data) {
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
        return data;
    }
}
