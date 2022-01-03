package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> {
    private final int nElements;
    private final List<T> unsortedList;

    public SelectionSort(List<T> data) {
        unsortedList = data;
        nElements = data.size();
    }

    public void sort() {
        int out, in, min;
        try {
            for (out = 0; out < nElements; out++) {
                min = out;
                for (in = out + 1; in < nElements; in++) {
                    if (unsortedList.get(in).compareTo(unsortedList.get(min)) < 0) { // Als waarde op positie in kleiner is dan waarde op positie min, dan:
                        min = in; // Kleinste waarde is in
                    }
                }
                swap(out, min); // Huidige kleinste waarde vanaf out wordt gewisseld met waarde op out
            }
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    public void sortDescending() {
        int out, in, max;
        try {
            for (out = 0; out < nElements; out++) {
                max = out;
                for (in = out + 1; in < nElements; in++) {
                    if (unsortedList.get(in).compareTo(unsortedList.get(max)) > 0) { // Als waarde op positie in groter is dan waarde op positie max, dan:
                        max = in; // Grootste waarde is in
                    }
                }
                swap(out, max); // Huidige grootste waarde vanaf out wordt gewisseld met waarde op out
            }
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    /**
     * Wisselt twee waardes in een lijst met elkaar
     * @param one Kleinere waarde
     * @param two Huidige grootste waarde
     */
    private void swap(int one, int two) {
        T temp = unsortedList.get(one);
        unsortedList.set(one, unsortedList.get(two));
        unsortedList.set(two, temp);
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }

    public void sortWithSortingLibDescending(ArrayList<T> array) {
        Collections.sort(array, Collections.reverseOrder());
    }
}
