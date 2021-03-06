package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SortTask<T> extends RecursiveAction {
    private List<T> array;
    private MergeSort mergeSort;

    public SortTask(List<T> array) {
        mergeSort = new MergeSort<>();
        this.array = array;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void compute() {
        if (array.size() > 1) {
            int mid = array.size() / 2;

            // Obtain the first half
            ArrayList<T> firstHalf = copy(array, 0, mid);
            ArrayList<T> secondHalf = copy(array, mid, array.size());

            SortTask<T> firstHalfTask = new SortTask<>(firstHalf);
            SortTask<T> secondHalfTask = new SortTask<>(secondHalf);

            invokeAll(firstHalfTask, secondHalfTask);

            mergeSort.merge(firstHalf, secondHalf, array);
        }
    }

    private ArrayList<T> copy(List<T> array, int start, int end) {
        ArrayList<T> emptyList = new ArrayList<>();

        for (int i = start; i < end; i++) {
            emptyList.add(array.get(i));
        }
        return emptyList;
    }
}
