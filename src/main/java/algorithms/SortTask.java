package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SortTask<T extends Comparable<T>> extends RecursiveAction {
    private final List<T> array;
    private final MergeSort<T> mergeSort;
    boolean descending;
    public String errorMessage;

    public SortTask(List<T> array) {
        mergeSort = new MergeSort<>();
        this.array = array;
    }

    public void setDescending(boolean descending) {
        this.descending = descending;
    }

    @Override
    protected void compute() {
        /**
         * Als de lijst meer dan 1 element bevat, wordt de lijst gesplit in 2 helften
         */
        if (array.size() > 1) {
            int mid = array.size() / 2;
            
            ArrayList<T> firstHalf = copy(array, 0, mid); // Eerste helft
            ArrayList<T> secondHalf = copy(array, mid, array.size()); // Tweede helft

            SortTask<T> firstHalfTask = new SortTask<>(firstHalf); // SortTask instantie met de eerste helft
            SortTask<T> secondHalfTask = new SortTask<>(secondHalf); // SortTask instantie met de tweede helft

            if (descending) {
                firstHalfTask.setDescending(true);
                secondHalfTask.setDescending(true);
            }

            invokeAll(firstHalfTask, secondHalfTask); // Door de twee instanties mee te geven wordt de compute methode aangeroepen van beide instanties.

            if (descending) {
                mergeSort.mergeDescending(firstHalf, secondHalf, array);
            } else {
                mergeSort.merge(firstHalf, secondHalf, array); // Mergen van de eerste helft, met de tweede helft, in een nieuwe array.
            }

            this.errorMessage = mergeSort.getErrorMessage();
        }
    }

    private ArrayList<T> copy(List<T> array, int start, int end) {
        ArrayList<T> newList = new ArrayList<>();

        for (int i = start; i < end; i++) {
            newList.add(array.get(i));
        }
        return newList;
    }
}
