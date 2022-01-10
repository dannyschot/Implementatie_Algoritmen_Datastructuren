package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Parallele Merge sort waarbij een sorteertaak wordt aangemaakt en een pool waarin subtaken uitgevoerd zullen worden
 * @param <T>
 */
public class ParallelMergeSort<T extends Comparable<T>> {
    private String errorMessage;

    public void sort(List<T> array) {
        try {
            SortTask<T> mainTask = new SortTask<T>(array);
            ForkJoinPool pool = new ForkJoinPool();
            /**
             * De mainTask instantie wordt meegegeven aan de pool. De taken zullen verder opgesplitst worden om vervolgens weer te joinen tot een gezamenlijk resultaat.
             */
            pool.invoke(mainTask);
            if (mainTask.errorMessage.length() > 0) {
                this.errorMessage = mainTask.errorMessage;
                System.out.println(mainTask.errorMessage);
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                this.errorMessage = "Dataset contains null values. Cannot sort null values.";
                System.out.println(this.errorMessage);
            }
        }
    }

    public void sortDescending(List<T> array) {
        try {
            SortTask<T> mainTask = new SortTask<T>(array);
            mainTask.setDescending(true);
            ForkJoinPool pool = new ForkJoinPool();
            pool.invoke(mainTask);
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                this.errorMessage = "Dataset contains null values. Cannot sort null values.";
                System.out.println(this.errorMessage);
            }
        }
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }

    public void sortWithSortingLibDescending(ArrayList<T> array) {
        array.sort(Collections.reverseOrder());
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
