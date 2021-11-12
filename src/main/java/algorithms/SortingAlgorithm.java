package algorithms;

import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgorithm {

    public <T extends Comparable<T>> void sort(JSONArray array) {
        ArrayList<T> list;
        list = convertToArrayList(array);

        insertionSort(list);
    }

    public <T> ArrayList<T> convertToArrayList(JSONArray array) {
        ArrayList<T> arrayList = new ArrayList<>();

        for (Object o : array) {
            arrayList.add((T) o);
        }
        return arrayList;
    }

    public <T> ArrayList<T> sortWithSortingLib(ArrayList array) {
        Collections.sort(array);
        return array;
    }

    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data) {
        int i, x;
        T currentNumber;
        for (i = 1; i < data.size(); i++){
            currentNumber = data.get(i);
            x = i - 1;
            while (x >= 0 && data.get(x).compareTo(currentNumber) > 0){
                data.set(x + 1, data.get(x));
                x--;
            }
            data.set(x + 1, currentNumber);
        }
        return data;
        }
}
