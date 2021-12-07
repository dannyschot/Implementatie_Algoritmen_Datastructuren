package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort<T extends Comparable<T>> {

    public void sort(List<T> array) {
        try {
            SortTask<T> mainTask = new SortTask<T>(array);
            ForkJoinPool pool = new ForkJoinPool();
            pool.invoke(mainTask);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }

}
