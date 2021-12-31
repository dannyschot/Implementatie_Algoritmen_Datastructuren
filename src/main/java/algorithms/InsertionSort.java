package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> {
    public void sort(List<T> data) {
        int in, out;
        try {
            for (out = 1; out < data.size(); out++){
                T temp = data.get(out);
                in = out;
                while (in > 0 && data.get(in - 1).compareTo(temp) >= 0){
                    data.set(in, data.get(in - 1));
                    --in;
                }
                data.set(in, temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public <T> void sortWithSortingLib(ArrayList array) {
        Collections.sort(array);
    }
}
