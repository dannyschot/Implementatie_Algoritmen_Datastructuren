package algorithms;

import org.json.simple.JSONArray;
import java.util.ArrayList;

public class SortingAlgorithm {

    public <T extends Comparable<T>> void sort(JSONArray array) {
        ArrayList<T> list;
        list = converToArrayList(array);

        insertionSort(list);
    }

    public <T> ArrayList<T> converToArrayList(JSONArray array) {
        ArrayList<T> arrayList = new ArrayList<>();

        for (Object o : array) {
            arrayList.add((T) o);
        }
        return arrayList;
    }

    public <T extends Comparable<T>> void insertionSort(ArrayList<T> data) {
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
        for (T datum : data) {
            System.out.println(datum);
        }

    }

}
