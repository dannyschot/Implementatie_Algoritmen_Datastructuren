package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> {
    List<T> unsortedList;

    public void sort(List<T> data) {
        unsortedList = data;
        recursiveSort(0, data.size() - 1);
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }

    private void recursiveSort(int left, int right) {
        try {
            if (right - left <= 0) {
                return;
            } else {
                T pivot = unsortedList.get(right);
                int partition = partition(left, right, pivot);
                recursiveSort(left, partition - 1);
                recursiveSort(partition + 1, right);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    private int partition(int left, int right, T pivot) {
        int leftPartition = left - 1;
        int rightPartition = right;

        while (true) {
            while (unsortedList.get(++leftPartition).compareTo(pivot) < 0){
            }
            while (rightPartition > 0 && unsortedList.get(--rightPartition).compareTo(pivot) > 0) {
            }
            if (leftPartition >= rightPartition) {
                break;
            } else {
                swap(leftPartition, rightPartition);
            }
        }
        swap(leftPartition, right);
        return leftPartition;
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
