package algorithms;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    private List<T> data;


    public BinarySearch(List<T> data) {
        this.data = data;
    }

    public int find(T searchKey) {
        int lowerBound = 0;
        int upperBound = data.size() - 1;

        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;
            if (searchKey.compareTo(data.get(mid)) < 0) {
                upperBound = mid - 1;
            } else if (searchKey.compareTo(data.get(mid)) > 0) {
                lowerBound = mid + 1;
            } else {
                return mid;
            }
        }
        return data.size();
    }
}